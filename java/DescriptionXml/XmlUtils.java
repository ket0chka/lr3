package DescriptionXml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Optional;

public class XmlUtils {
    public static <T> Optional<T> parse(String path, Class<T> clazz) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            T cfg = (T) jaxbUnmarshaller.unmarshal(new File(path));
            return Optional.ofNullable(cfg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
