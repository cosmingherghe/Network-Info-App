If you found this project helpful or interesting and would like to buy me a beer, you can 🍻[![Donate](https://img.shields.io/badge/Donate-PayPal-blue.svg)](https://paypal.me/cosminsoy)  Thank you for your support!

# 🔌Network Information Application
This Spring Boot application provides detailed information about network interfaces and can be deployed on various containers. It's built as part of my learning process on networking concepts like IP addresses, MAC addresses, loopback interfaces, multicast support, and more.

## Try the Application with Docker

This application is containerized for easy deployment and portability. You can pull the latest Docker image directly from Docker Hub and run it in a few simple steps.

### Quick Start

1. **Pull the Docker image**:

   ```bash
   docker pull cosmingherghedev/netinfo:latest
   ```

2. **Run the container**:

   ```bash
   docker run -d -p 8080:8080 cosmingherghedev/netinfo:latest
   ```

   This command will start the application in a detached state, mapping the container’s port 8080 to your local machine’s port 8080.

3. **Access the application**:

   Once the container is running, open your browser and navigate to:

   ```
   http://localhost:8080
   ```

   You should see the application’s interface displaying detailed network information.

### Notes

- **Port**: Make sure port 8080 is available on your machine, or adjust the port mapping as needed.
- **Container Management**: You can stop the container anytime with:

   ```bash
   docker stop <container_id>
   ```

## Application Features
- Retrieves detailed information on network cards such as:
    - MAC address
    - IP (IPv4/IPv6) addresses
    - Loopback and point-to-point status
    - Multicast support
    - Maximum Transmission Unit (MTU)
    - Virtual/Physical interface detection
- Supports deployment on different containers using Docker.

## Technologies
- Spring Boot - for building the web application.
- Java - for writing the core logic.
- Docker - for containerizing the application.
