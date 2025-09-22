## java

```shell
#0. при необходимости ставим openjdk 21 и maven 3 любым удобным способом
#1. открываем проект в IDE из папки java
#2. устанавливаем зависимости в IDE или командой
mvn dependency:resolve
#3. запускаем тесты в IDE или командой
mvn clean test
```