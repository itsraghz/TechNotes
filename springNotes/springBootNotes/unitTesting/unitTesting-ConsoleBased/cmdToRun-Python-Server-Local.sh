#!/bin/bash

# Colors for terminal output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# Default port
PORT=8000

# Banner function
print_banner() {
    echo -e "${GREEN}=================================${NC}"
    echo -e "${GREEN}   Python Local Server Launcher   ${NC}"
    echo -e "${GREEN}=================================${NC}"
}

# Help function
show_help() {
    echo -e "\nUsage: $0 [-p port_number]"
    echo -e "\nOptions:"
    echo -e "  -p PORT\tSpecify custom port number (default: 8000)"
    echo -e "  -h\t\tShow this help message\n"
}

# Process command line arguments
while getopts "p:h" opt; do
    case ${opt} in
        p )
            PORT=$OPTARG
            if ! [[ "$PORT" =~ ^[0-9]+$ ]] || [ "$PORT" -lt 1024 ] || [ "$PORT" -gt 65535 ]; then
                echo -e "${RED}Error: Port must be a number between 1024 and 65535${NC}"
                exit 1
            fi
            ;;
        h )
            show_help
            exit 0
            ;;
        \? )
            echo -e "${RED}Invalid option: $OPTARG${NC}" 1>&2
            show_help
            exit 1
            ;;
    esac
done

# Print banner
print_banner

# Check if Python is installed
echo -e "\n${YELLOW}Checking Python installation...${NC}"
if ! command -v python3 &> /dev/null && ! command -v python &> /dev/null; then
    echo -e "${RED}Error: Python is not installed!${NC}"
    echo -e "Please install Python 3 to continue."
    exit 1
fi

# Try python3 first, fall back to python if necessary
if command -v python3 &> /dev/null; then
    PYTHON_CMD="python3"
else
    PYTHON_CMD="python"
fi

echo -e "${GREEN}Python found: $($PYTHON_CMD --version)${NC}"

# Check if port is already in use
if nc -z localhost $PORT 2>/dev/null; then
    echo -e "${RED}Error: Port $PORT is already in use!${NC}"
    echo -e "Please try a different port using the -p option."
    exit 1
fi

# Start the server
echo -e "\n${YELLOW}Starting Python HTTP server on port $PORT...${NC}"
echo -e "${GREEN}You can access the server at:${NC}"
echo -e "  http://localhost:$PORT"
echo -e "  http://127.0.0.1:$PORT"
echo -e "\n${YELLOW}Press Ctrl+C to stop the server${NC}\n"

# Run the server
$PYTHON_CMD -m http.server $PORT || {
    echo -e "\n${RED}Error: Failed to start the server!${NC}"
    exit 1
}

