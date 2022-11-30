# Graduation project

Used website: https://apteka.103.by/
************************************

Команда для запуска селенид тестов:

mvn clean test -DsuiteXmlFile='selenideTest' -Dconfig='apteka103'

Команда для запуска основных тестов:

mvn clean test -DsuiteXmlFile='test' -Dconfig='apteka103'

Команда для создания отчета Allure:

mvn allure:report


