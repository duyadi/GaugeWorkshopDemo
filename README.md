# GaugeWorkshopDemo

##Install
- $ brew update
- $ brew install gauge
- $ gauge —install java
- $ gauge -v

##Report Plugin
- gauge --install html-report

##Excute spec
- mvn gauge:execute -DspecsDir=specs
- mvn gauge:execute -DspecsDir=specs -Dtags="tag name"

