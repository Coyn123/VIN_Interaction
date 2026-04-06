# VIN Lookup

A command-line tool that decodes a Vehicle Identification Number (VIN) using the NHTSA vPIC API and prints structured vehicle data to the terminal.

## Prerequisites
- Java 11+
- Maven

## Build & Run
```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.coy.Main"
```

Enter a VIN when prompted. Example: `WBA13BJ06MWX31988`

## Example Output
```
Make: BMW
Model: 530i
ModelYear: 2021
Trim: xDrive
DriveType: AWD/All-Wheel Drive
EngineHP: 248
FuelTypePrimary: Gasoline
TransmissionStyle: Automatic
BodyClass: Sedan/Saloon
VehicleType: PASSENGER CAR
```
