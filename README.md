# KostalInverterClient
Simple modbus TCP client implementation to connect to a KOSTAL Inverter and read out data from it.
Please refer to [this](https://www.photovoltaikforum.com/core/attachment/81082-ba-kostal-interface-modbus-tcp-sunspec-pdf) document to learn more about the modbus protocol.

### Currently supported features

- Read Holding Registers

### Download
Maven:
```xml
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>

<dependency>
  <groupId>com.github.spyderscript</groupId>
  <artifactId>KostalInverterClient</artifactId>
  <version>1.1</version>
</dependency>
```
JAR:
Download the [latest release](https://github.com/SpyderScript/KostalInverterClient/releases/latest).


### Code example
```java
import de.spyderscript.inverter.client.InverterClient;
import de.spyderscript.inverter.register.InverterAddress;
import de.spyderscript.modbus.tcp.ModbusException;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class Example {
    public static void main(String[] args) throws IOException, ModbusException {
        InverterClient client = new InverterClient(new InetSocketAddress(InetAddress.getByName("[IP-Address]"), 1502), (byte) 71);
        client.connect();

        float generationPower = (float) client.read(InverterAddress.POWER_DC1).getData() + (float) client.read(InverterAddress.POWER_DC2).getData();
        float consumptionPower = (float) client.read(InverterAddress.HOME_OWN_CONSUMPTION_FROM_PV).getData() + (float) client.read(InverterAddress.HOME_OWN_CONSUMPTION_FROM_GRID).getData() + (float) client.read(InverterAddress.HOME_OWN_CONSUMPTION_FROM_BATTERY).getData();

        System.out.println("generationPower -> " + generationPower);
        System.out.println("consumptionPower -> " + consumptionPower);

        client.disconnect();
    }
}
```
