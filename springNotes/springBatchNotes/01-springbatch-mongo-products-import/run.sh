#!/bin/bash

function start_dev() {
    echo "Starting MongoDB and Mongo Express..."
    docker-compose up -d
    echo "Waiting for MongoDB to start..."
    sleep 5
    echo "Building and running the application..."
    ./mvnw spring-boot:run
}

function run_tests() {
    echo "Running tests..."
    ./mvnw clean test
}

function build_docker() {
    echo "Building Docker image..."
    ./mvnw clean package
    docker build -t product-batch-import .
}

function show_help() {
    echo "Usage: ./run.sh [command]"
    echo "Commands:"
    echo "  dev         - Start development environment"
    echo "  test        - Run tests"
    echo "  build       - Build Docker image"
    echo "  help        - Show this help message"
}

case "$1" in
    "dev")
        start_dev
        ;;
    "test")
        run_tests
        ;;
    "build")
        build_docker
        ;;
    "help"|"")
        show_help
        ;;
    *)
        echo "Unknown command: $1"
        show_help
        exit 1
        ;;
esac

