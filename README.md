# vass-code-challenge

### Construir la imagen del proyecto
    docker build -t vass-code-challenge:vass-code-challenge-docker .
### Arrancar la imagen del proyecto
    docker run -p 8081:8080 -d --name vass-code-challenge vass-code-challenge:vass-code-challenge-docker .
### Probar la petición con curl
    curl --location 'localhost:8081/price?productId=35455&brandId=1&date=2020-06-14T21%3A00%3A00'

