#!/bin/bash

# Build all images
echo "Building Docker images for all Java versions..."
docker-compose build

# Function to run container and remove it after execution
run_version() {
    version=$1
    echo -e "\n========================================="
    echo "Running Java $version example"
    echo -e "=========================================\n"
    docker-compose run --rm "java$version"
    echo -e "\n-----------------------------------------\n"
}

# Run each version sequentially
run_version 7
run_version 8
run_version 11
run_version 17
run_version 21

# Cleanup
echo "Cleaning up..."
docker-compose down

echo "All versions completed!"

