# Microservicio de Películas - Spring Boot

## Descripción
Este es un microservicio desarrollado en Spring Boot que proporciona información básica sobre películas. Permite obtener detalles sobre películas específicas usando su identificador (ID) y también obtener la lista completa de películas registradas.

## Características
- Desarrollado en Spring Boot
- API REST con endpoints JSON
- Datos almacenados en memoria (sin base de datos)
- Incluye 6 películas de Studio Ghibli como ejemplos

## Endpoints
- `GET /peliculas` - Obtiene todas las películas registradas
- `GET /peliculas/{id}` - Obtiene una película específica por su ID

## Modelo de Datos
Cada película contiene los siguientes atributos:
- `id`: Identificador único
- `titulo`: Título de la película
- `año`: Año de lanzamiento
- `director`: Director de la película
- `genero`: Género cinematográfico
- `sinopsis`: Descripción breve de la película

## Requisitos del Sistema
- Java 17 o superior
- Maven 3.6 o superior

## Cómo ejecutar el proyecto

### Opción 1: Usando Maven Wrapper (Recomendado)
```bash
# 1. Compilar el proyecto
./mvnw clean compile

# 2. Ejecutar la aplicación
./mvnw spring-boot:run
```

### Opción 2: Si tienes Maven instalado
```bash
# 1. Compilar el proyecto
mvn clean compile

# 2. Ejecutar la aplicación
mvn spring-boot:run
```

### 3. Acceder a la aplicación
La aplicación estará disponible en: `http://localhost:8081`

### 4. Probar los endpoints
Usa el script de pruebas incluido:
```bash
./test-api.sh
```

**Nota**: La primera ejecución puede tardar varios minutos en descargar las dependencias de Maven.

## Ejemplos de uso

### 1. Obtener todas las películas
**Endpoint**: `GET /peliculas`  
**Comando**:
```bash
curl http://localhost:8081/peliculas
```

**Respuesta esperada**:
```json
[
  {
    "id": 1,
    "titulo": "El Viaje de Chihiro",
    "año": 2001,
    "director": "Hayao Miyazaki",
    "genero": "Animación",
    "sinopsis": "Una niña de 10 años se adentra en un mundo mágico..."
  }
]
```

### 2. Obtener una película específica por ID
**Endpoint**: `GET /peliculas/{id}`  
**Ejemplo**: `GET /peliculas/1`  
**Comando**:
```bash
curl http://localhost:8081/peliculas/1
```

**Respuesta esperada**:
```json
{
  "id": 1,
  "titulo": "El Viaje de Chihiro",
  "año": 2001,
  "director": "Hayao Miyazaki",
  "genero": "Animación",
  "sinopsis": "Una niña de 10 años se adentra en un mundo mágico..."
}
```

### 3. Probando película que no existe
**Comando**:
```bash
curl -i http://localhost:8081/peliculas/999
```

**Respuesta esperada**: HTTP 404 Not Found

## Películas incluidas (Studio Ghibli)
1. El Viaje de Chihiro (2001)
2. Mi Vecino Totoro (1988)
3. La Princesa Mononoke (1997)
4. El Chico y la Garza (2023)
5. Kiki: Entregas a Domicilio (1989)
6. El Castillo Ambulante (2004)

## Estructura del proyecto
```
src/
├── main/
│   ├── java/
│   │   └── com/duoc/peliculas/
│   │       ├── PeliculasMicroservicioApplication.java
│   │       ├── controller/
│   │       │   └── PeliculaController.java
│   │       ├── model/
│   │       │   └── Pelicula.java
│   │       └── service/
│   │           └── PeliculaService.java
│   └── resources/
│       └── application.properties
└── test/
```