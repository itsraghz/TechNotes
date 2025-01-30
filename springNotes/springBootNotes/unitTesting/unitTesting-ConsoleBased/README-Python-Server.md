# Python Server Automation Script Documentation

## Overview
The `cmdToRun-Python-Server-Local.sh` script is a sophisticated bash script designed to automate the process of starting a Python HTTP server with enhanced functionality, error handling, and user feedback. It provides a robust way to serve local directories while ensuring proper Python version compatibility and port availability.

## Features
- 🎨 Color-coded console output for better readability
- 🔍 Automatic Python version detection (Python 2.x vs 3.x)
- 🔒 Port availability checking
- 📝 Detailed logging with timestamps
- 🚀 One-command server startup
- ⚠️ Comprehensive error handling
- 📋 Command-line argument processing

## Requirements
- Unix-like operating system (Linux/macOS)
- Python (supports both Python 2.x and 3.x)
- Bash shell
- Basic network port access rights

## Usage
### Basic Command
```bash
./cmdToRun-Python-Server-Local.sh [port_number]
```

### Examples
1. Start with default port (8000):
```bash
./cmdToRun-Python-Server-Local.sh
```

2. Start with custom port:
```bash
./cmdToRun-Python-Server-Local.sh 8080
```

## Code Breakdown

### Color Definitions
```bash
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color
```
These ANSI color codes are used to provide visual feedback in the terminal:
- RED: Used for errors and warnings
- GREEN: Used for success messages
- YELLOW: Used for important information
- NC: Resets text color

### Banner Function
```bash
print_banner() {
    echo -e "${GREEN}================================${NC}"
    echo -e "${GREEN}   Python Server Automation     ${NC}"
    echo -e "${GREEN}================================${NC}"
}
```
Creates a visually appealing header for the script execution.

### Port Validation
The script includes sophisticated port validation:
```bash
validate_port() {
    if ! [[ "$1" =~ ^[0-9]+$ ]] || [ "$1" -lt 1024 ] || [ "$1" -gt 65535 ]; then
        return 1
    fi
    return 0
}
```
- Ensures port is a valid number
- Checks if port is within valid range (1024-65535)
- Prevents use of privileged ports

### Python Version Detection
```bash
if command -v python3 &>/dev/null; then
    PYTHON_CMD="python3"
elif command -v python &>/dev/null; then
    PYTHON_CMD="python"
else
    echo -e "${RED}Error: Python is not installed${NC}"
    exit 1
fi
```
Automatically detects available Python version and sets appropriate command.

## Flow of Execution
1. Script starts with banner display
2. Processes command-line arguments for port number
3. Validates port number and availability
4. Detects Python version
5. Creates timestamped log file
6. Starts Python server with appropriate command
7. Provides feedback about server status

## Error Handling
The script handles various error conditions:
- Invalid port numbers
- Already occupied ports
- Missing Python installation
- Permission issues
- Invalid arguments

## Logging
- Creates detailed logs with timestamp in format:
```
consoleOutput_DD-MM-YYYY-DDD-HHMMSS-TZ.txt
```
- Captures both stdout and stderr
- Maintains history of server sessions

## Best Practices
1. Always check the port availability before starting
2. Use ports above 1024 to avoid permission issues
3. Monitor the generated log files for troubleshooting
4. Keep the script executable (`chmod +x`)

## Troubleshooting
### Common Issues and Solutions
1. **Permission Denied**
- Ensure script has execute permissions
- Use `chmod +x cmdToRun-Python-Server-Local.sh`

2. **Port Already in Use**
- Choose a different port
- Check running processes with `lsof -i :[port]`

3. **Python Not Found**
- Verify Python installation
- Ensure PATH includes Python binary

## Contributing
Feel free to submit issues and enhancement requests for improving the script.

## License
This script is provided as-is under the MIT License.

