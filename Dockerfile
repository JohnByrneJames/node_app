# Use the base image
FROM node AS app

# Define the working DIR inside the container
WORKDIR /usr/src/app

# Copy dependencies - If you don't know go to the documentation
COPY package*.json ./

# Install npm
RUN npm install

# Copy everything from OS to container
COPY . .

# Second stage of our build for production ~
# multi stage Docker build
#FROM node:alpine

# Copy only essential things to this layer
# This line compresses the size whilst still providing full functionality
#COPY --from=app /usr/src/app /usr/src/app

# Define work directory in second stage
#WORKDIR /usr/src/app

# Open up the port (3000) - Default port of Node.JS 
EXPOSE 3000

# Start NPM
CMD ["npm", "start"]

# RUN THE APP WTIH CMD
CMD ["node","app.js"]