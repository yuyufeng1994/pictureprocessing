package top.yuyufeng.demo.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.UUID;

/**
 * @author yuyufeng
 * @date 2018/11/29.
 */
@RestController
@RequestMapping("file")
public class FileController {

    /**
     * 上传图片
     *
     * @param file
     * @throws IOException
     */
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID().toString();
        String ext = StringUtils.getFilenameExtension(file.getOriginalFilename());
        if (StringUtils.isEmpty(ext)) {
            ext = "png";
        }
        file.transferTo(new File("g://test/" + fileName + "." + ext));
        return "http://127.0.0.1:8080/file/stream/" + fileName + "/" + ext;
    }


    /**
     * 文件流
     *
     * @param response
     * @return
     */
    @RequestMapping(value = "stream/{fileName}/{ext}", method = RequestMethod.GET)
    public String thumbnail(HttpServletResponse response, @PathVariable("fileName") String fileName, @PathVariable("ext") String ext) {
        try {
            InputStream inputStream = new FileInputStream("g://test/" + fileName + "." + ext);
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[1024];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
            // 这里主要关闭。
            os.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
