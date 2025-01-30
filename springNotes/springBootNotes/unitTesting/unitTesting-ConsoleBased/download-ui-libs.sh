#!/bin/bash

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Base directory for libraries
LIB_DIR="lib"

# Create directory structure
echo -e "${BLUE}Creating directory structure...${NC}"
mkdir -p "${LIB_DIR}/css"
mkdir -p "${LIB_DIR}/js"
mkdir -p "${LIB_DIR}/fonts"

# Function for downloading files
download_file() {
    local url=$1
    local output=$2
    local description=$3
    
    if [ -f "$output" ]; then
        echo -e "${BLUE}$description already exists. Skipping...${NC}"
    else
        echo -e "${BLUE}Downloading $description...${NC}"
        if curl -sSL "$url" -o "$output"; then
            echo -e "${GREEN}Successfully downloaded $description${NC}"
        else
            echo -e "${RED}Failed to download $description${NC}"
            exit 1
        fi
    fi
}

# Download Bootstrap CSS and JS
download_file "https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" \
    "${LIB_DIR}/css/bootstrap.min.css" \
    "Bootstrap CSS"

download_file "https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" \
    "${LIB_DIR}/js/bootstrap.bundle.min.js" \
    "Bootstrap JS"

# Download Bootstrap Icons
download_file "https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.css" \
    "${LIB_DIR}/css/bootstrap-icons.css" \
    "Bootstrap Icons CSS"

download_file "https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/fonts/bootstrap-icons.woff" \
    "${LIB_DIR}/fonts/bootstrap-icons.woff" \
    "Bootstrap Icons WOFF"

download_file "https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/fonts/bootstrap-icons.woff2" \
    "${LIB_DIR}/fonts/bootstrap-icons.woff2" \
    "Bootstrap Icons WOFF2"

# Download Highlight.js
download_file "https://cdn.jsdelivr.net/gh/highlightjs/cdn-release@11.9.0/build/highlight.min.js" \
    "${LIB_DIR}/js/highlight.min.js" \
    "Highlight.js JS"

download_file "https://cdn.jsdelivr.net/gh/highlightjs/cdn-release@11.9.0/build/styles/default.min.css" \
    "${LIB_DIR}/css/highlight-default.min.css" \
    "Highlight.js CSS"

# Make script executable
chmod +x "$0"

echo -e "${GREEN}All libraries have been downloaded successfully!${NC}"

