# Guía de Validación del Microservicio de Películas

## Lista de Verificación - Cumplimiento de Requisitos

### 1. Framework y Tecnología
- Desarrollado en Spring Boot
- Usa Java como lenguaje de programación 
- Configurado con Maven como gestor de dependencias

### 2. Endpoints Requeridos
- `GET /peliculas/{id}` - Obtener película por ID
- `GET /peliculas` - Obtener todas las películas

### 3. Modelo de Datos
La clase `Pelicula` incluye todos los atributos requeridos:
- `id` (Long)
- `titulo` (String)
- `año` (Integer) 
- `director` (String)
- `genero` (String)
- `sinopsis` (String)

### 4. Almacenamiento en Memoria
- Datos almacenados en memoria (sin base de datos)
- Lista inicializada en la clase `PeliculaService`
- Incluye 6 películas de Studio Ghibli (más de las 5 requeridas)

### 5. Respuestas JSON
- Controlador configurado con `@RestController`
- Respuestas automáticas en formato JSON
- Manejo de errores con códigos HTTP apropiados

## Películas Incluidas (Studio Ghibli)

| ID | Título | Año | Director | Género |
|----|--------|-----|----------|---------|
| 1 | El Viaje de Chihiro | 2001 | Hayao Miyazaki | Animación |
| 2 | Mi Vecino Totoro | 1988 | Hayao Miyazaki | Animación |
| 3 | La Princesa Mononoke | 1997 | Hayao Miyazaki | Animación |
| 4 | El Chico y la Garza | 2023 | Hayao Miyazaki | Animación |
| 5 | Kiki: Entregas a Domicilio | 1989 | Hayao Miyazaki | Animación |
| 6 | El Castillo Ambulante | 2004 | Hayao Miyazaki | Animación |

## Comandos de Prueba Rápida

### Iniciar el Microservicio
```bash
./mvnw spring-boot:run
```

### Probar Endpoints (en otra terminal)
```bash
# Todas las películas
curl http://localhost:8081/peliculas

# Película específica
curl http://localhost:8081/peliculas/1

# Película inexistente (debe devolver 404)
curl -i http://localhost:8081/peliculas/999
```

### Script de Pruebas Automatizado
```bash
./test-api.sh
```

## Estructura del Proyecto Creado

```
pelicula-tarea-/
├── src/
│   ├── main/
│   │   ├── java/com/duoc/peliculas/
│   │   │   ├── PeliculasMicroservicioApplication.java    # Clase principal
│   │   │   ├── controller/
│   │   │   │   └── PeliculaController.java               # Controlador REST  
│   │   │   ├── model/
│   │   │   │   └── Pelicula.java                        # Modelo de datos
│   │   │   └── service/
│   │   │       └── PeliculaService.java                 # Servicio con datos
│   │   └── resources/
│   │       └── application.properties                    # Configuración
│   └── test/
│       └── java/com/duoc/peliculas/controller/
│           └── PeliculaControllerTest.java              # Pruebas unitarias
├── .mvn/wrapper/                                        # Maven Wrapper
├── mvnw                                                 # Script Maven (Linux/Mac)
├── pom.xml                                             # Configuración Maven
├── test-api.sh                                         # Script de pruebas
├── README.md                                           # Documentación
└── .gitignore                                          # Archivos ignorados
```

## Puntos Clave del Desarrollo

1. **Controlador REST** (`PeliculaController`):
   - Maneja las rutas `/peliculas` y `/peliculas/{id}`
   - Devuelve respuestas JSON automáticamente
   - Maneja errores 404 para películas no encontradas

2. **Servicio de Datos** (`PeliculaService`):
   - Inicializa lista de películas en memoria
   - Proporciona métodos para obtener películas
   - Usa `Optional` para manejo seguro de valores nulos

3. **Modelo** (`Pelicula`):
   - POJO simple con todos los atributos requeridos
   - Anotaciones Jackson para serialización JSON
   - Constructores y métodos getter/setter

4. **Configuración**:
   - Puerto 8081 por defecto
   - Logs en nivel DEBUG para desarrollo
   - Sin configuración de base de datos

## Características Adicionales Implementadas

- **Validación robusta**: Manejo de errores y casos edge
- **Testing**: Pruebas unitarias incluidas  
- **Documentación**: README completo y comentarios en código
- **Facilidad de uso**: Scripts de prueba y Maven Wrapper
- **JSON elegante**: Formato de respuesta limpio y consistente
- **Internacionalización**: Código en inglés, contenido en español

## Para Entregar

1. Código fuente completo
2. README con instrucciones
3. Ejemplos de uso y testing
4. Repositorio Git con commits
5. Documentación de endpoints

