#!/bin/bash

set -e

if ! command -v docker &> /dev/null; then
    echo "Docker is not installed, Please install Docker and try again."
    exit 1
fi

echo "Docker is installed. Continuing build..."

REPO_URL="https://github.com/jason-erasmus/Think_java_6-9.git"
REPO_NAME="Think_java_11-19"
CLONE_DIR="Think_java_11-19"

echo "Cloning the repository..."
rm -rf $CLONE_DIR
git clone $REPO_URL $CLONE_DIR

cd $CLONE_DIR

echo "Building Docker image..."
docker build -t think-java .

echo "Launching Think Java..."
docker run -it think-java