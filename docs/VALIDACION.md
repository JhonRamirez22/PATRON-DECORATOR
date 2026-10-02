# Validación y evidencia

Fecha: 2 de octubre de 2026. Entorno: macOS, Java 21 y Maven 3.9.11. Las tarifas son sintéticas.

## Compilación y pruebas Java

Se generó `target/decorator-lab-1.0.0.jar` con Spring Boot 4.1.1. La compilación con pruebas ejecutó seis pruebas JUnit: seis correctas, cero fallos y cero errores. Después se recompiló el JAR con `-DskipTests` para incorporar tres ajustes visuales; el código Java no cambió. Reportes: `target/surefire-reports/`.

En este entorno se utilizó un repositorio Maven temporal:

```sh
mvn -q -o -Dmaven.repo.local=/private/tmp/decorator-m2 package
```

Ese comando depende de las dependencias descargadas en esta máquina. Para una instalación nueva utiliza `mvn clean package`, como indica el README.

Cobertura comprobada:

| Comprobación | Resultado |
|---|---|
| Bogotá → Medellín, 2 kg, sin extras | $36.400; 48 h |
| Refrigeración y monitoreo | $76.000; expresión Java anidada |
| Seguro → Prioridad | $65.280; 36 h |
| Prioridad → Seguro | $61.680; 36 h |
| Seguro mínimo | $8.000 de recargo |
| Listas de una cotización | Inmutables |
| Ruta igual, peso inválido, servicio duplicado/desconocido | Rechazados |

## API en ejecución

Se comprobó el JAR empaquetado en `http://127.0.0.1:8080`:

- Página principal: HTTP 200; catálogo Thymeleaf con las clases de decorador.
- Catálogo: cinco servicios.
- Cotización por POST: los resultados de la tabla anterior.
- Ruta con origen igual a destino, selección duplicada y servicio desconocido: HTTP 400 con mensaje.
- Exportación por GET: JSON con total $65.280 y cabecera de descarga.
- Respuesta de ejemplo conservada en `docs/examples/cotizacion.json`.

## Frontend en navegador

Se comprobó en el navegador integrado:

- Cálculo del escenario predeterminado ($76.000).
- Reordenamiento con flechas: el total cambia de $65.280 a $61.680; el foco permanece en la capa movida.
- Ruta inválida: muestra «El origen y el destino deben ser diferentes» y desactiva la exportación.
- Recuperación al elegir nuevamente un escenario válido.
- Descarga efectiva de `celsius-cotizacion.json` a través del endpoint Java.
- Sintaxis de JavaScript comprobada con `node --check`.
- Capturas de escritorio y móvil sin desbordamiento horizontal.

Las capturas solicitaron anchuras de 1440 y 390 píxeles; la escala del navegador produjo anchuras CSS de 1600 y 433, respectivamente. No constituyen una comprobación de todos los tamaños o navegadores. La vista de escritorio se conserva en `docs/images/vista-escritorio.jpg`; su procedencia está en el archivo `.source.txt` adjunto.

Hay estilos para impresión y para movimiento reducido. No se abrió el diálogo de impresión ni se efectuó una entrega logística real.

## Revisión de diseño

Revisión independiente Impeccable finalizada con disposición **ship**. Se corrigieron dos rótulos superiores redundantes, la sombra interior de una perforación y un icono Unicode sustituido por SVG. El revisor comprobó las recapturas y cerró los tres hallazgos sin regresiones materiales.

El detector estático no resolvió la ruta pública `/css/app.css` de Spring y emitió una advertencia de jerarquía plana. La revisión visual confirmó una escala clara de Barlow Condensed frente a cuerpo, código y datos. El detector no se repitió.

La dirección se implementó en código primero; no existe un mockup aprobado por el usuario. El contrato registra la elección del manual en láminas tras la instrucción de continuar. El seed quedó registrado en la sesión y en el contrato; no se conservó un log independiente del concept roll.

Sistema visual documentado en `DESIGN.md` y `.impeccable/design.json`.

## Límites

La comprobación corresponde a un simulador local de cotización. No integra transportistas, aseguradoras, sensores, pagos, cuentas o base de datos. Los cálculos usan datos de ejemplo y no certifican condiciones de transporte farmacéutico.
