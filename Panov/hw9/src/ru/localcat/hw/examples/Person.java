package ru.localcat.hw.examples;

import lombok.*;
import ru.localcat.hw.xmlserializer.annotations.XmlIgnore;
import ru.localcat.hw.xmlserializer.annotations.XmlName;
import ru.localcat.hw.xmlserializer.annotations.XmlTypeName;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@XmlTypeName("People")
public class Person {
    @XmlName("Name")
    private String firstName;
    @XmlName("Age")
    private int age;
    @XmlIgnore
    private String address;
}
