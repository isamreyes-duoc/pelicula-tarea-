#!/bin/bash

echo "🎬 Testing Movies Microservice"
echo "=============================="
echo ""

echo "1. Checking if the service is running..."
if curl -s http://localhost:8081/peliculas > /dev/null 2>&1; then
    echo "✅ Service active on port 8081"
else
    echo "❌ Service not available. Starting it..."
    echo "Run: ./mvnw spring-boot:run"
    echo "Then run this script again."
    exit 1
fi

echo ""
echo "2. 📋 Getting all movies:"
echo "GET /peliculas"
echo "---------------------------------------------"
curl -s http://localhost:8081/peliculas | python3 -m json.tool || curl -s http://localhost:8081/peliculas

echo ""
echo ""
echo "3. 🎭 Getting specific movie (ID: 1):"
echo "GET /peliculas/1"
echo "---------------------------------------------"
curl -s http://localhost:8081/peliculas/1 | python3 -m json.tool || curl -s http://localhost:8081/peliculas/1

echo ""
echo ""
echo "4. 🎪 Getting specific movie (ID: 3):"
echo "GET /peliculas/3"  
echo "---------------------------------------------"
curl -s http://localhost:8081/peliculas/3 | python3 -m json.tool || curl -s http://localhost:8081/peliculas/3

echo ""
echo ""
echo "5. 🚫 Testing non-existent movie (ID: 999):"
echo "GET /peliculas/999"
echo "---------------------------------------------"
HTTP_STATUS=$(curl -s -o /dev/null -w "%{http_code}" http://localhost:8081/peliculas/999)
echo "Status Code: $HTTP_STATUS"
if [ "$HTTP_STATUS" = "404" ]; then
    echo "✅ Correct 404 response for non-existent movie"
else
    echo "❌ Unexpected status code"
fi

echo ""
echo "🎉 Tests completed!"
echo "🎉 ¡Pruebas completadas!"