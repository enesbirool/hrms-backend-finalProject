package kodlamaio_birol.hrms.core.helpers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import kodlamaio_birol.hrms.core.utilities.results.DataResult;
import kodlamaio_birol.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio_birol.hrms.core.utilities.results.SuccessDataResult;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryManager implements CloudinaryService {

    Cloudinary cloudinary;

    public CloudinaryManager() {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "---",
                "api_key", "---",
                "api_secret", "---"));
    }

    @Override
    public DataResult<Map> addPicture(MultipartFile multipartFile) throws IOException {
        Map<String, Object> options = new HashMap<>();
        var allowedFormats = Arrays.asList("png", "jpg", "jpeg");
        options.put("allowed_formats", allowedFormats);
        File file = convertToFile(multipartFile);
        Map uploader = null;
        try {
            uploader = cloudinary.uploader().upload(file, options);
        } catch (Exception e) {
            return new ErrorDataResult<>(e.getMessage());
        }
        return new SuccessDataResult<>(uploader);
    }

    private File convertToFile(MultipartFile multipartFile) throws IOException {
        File file = new File("C:\\Users\\mx\\IdeaProjects\\Java\\HRMS_Spring\\hrms\\Pictures\\" + multipartFile.getOriginalFilename());
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();
        return file;
    }
}
