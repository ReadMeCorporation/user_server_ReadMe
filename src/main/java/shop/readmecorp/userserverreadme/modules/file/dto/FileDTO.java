package shop.readmecorp.userserverreadme.modules.file.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileDTO {

    private Integer id;

    private String fileName;

    private String fileUrl;
}
