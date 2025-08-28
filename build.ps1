
$ErrorActionPreference = "Stop"

# Check for Docker
if (-not (Get-Command docker -ErrorAction SilentlyContinue)) {
    Write-Host "Docker is not installed. Please install Docker and try again."
    exit 1
}

Write-Host "Docker is installed. Continuing build..."

$REPO_URL = "https://github.com/jason-erasmus/Think_java_6-9.git"
$CLONE_DIR = "Think_java_6-9"

Write-Host "Cloning the repository..."
if (Test-Path $CLONE_DIR) {
    Remove-Item -Recurse -Force $CLONE_DIR
}
git clone $REPO_URL $CLONE_DIR

Set-Location $CLONE_DIR

Write-Host "Building Docker image..."
docker build -t think-java

Write-Host "Launching Think Java..."
docker run -it think-java