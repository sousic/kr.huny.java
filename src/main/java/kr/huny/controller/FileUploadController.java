package kr.huny.controller;

import kr.huny.controller.common.baseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sousic on 2016-10-12.
 */
@Controller
@RequestMapping(value = "/attach")
public class FileUploadController extends baseController {
    /*
    @Autowired
    private AttachmentsService attachmentsService;


    @RequestMapping(value = "upload", method = RequestMethod.POST, produces = "application/json;charset=utf8")
    public @ResponseBody
    Map<String, Object> upload(long bm_seq, long a_seq, MultipartFile uploadFile)
    {
        resultJson = new HashMap<String, Object>();
        resultJson.put("resultCode", 1);
        resultJson.put("resultMsg", "성공");

        String attachmentsURL = null;

        AttachmentsVO attachmentsVO = new AttachmentsVO();

        try {
            UploadFileHelper.FileInfo fileInfo = UploadFileHelper.uploadFile(propertyHelper.getUploadPath(), uploadFile.getOriginalFilename(), uploadFile.getBytes());

            attachmentsVO.setFilename(uploadFile.getOriginalFilename());
            attachmentsVO.setFilesize(uploadFile.getSize());
            attachmentsVO.setContentType(uploadFile.getContentType());
            attachmentsVO.setSave_name(fileInfo.getDestFileName());
            attachmentsVO.setSave_path(fileInfo.getDestSavePath().replace("\\","/"));
            attachmentsVO.setBm_seq(bm_seq);
            attachmentsVO.setA_seq(a_seq);
            //attachmentsService.insertAttachments(attachmentsVO);
            logger.info(attachmentsVO.toString());

            attachmentsURL = String.format("/attach/file/%s", attachmentsVO.getSeq());

        } catch (Exception ex) {
            new LogException(ex).printStackTrace();
        }

        resultJson.put("url", attachmentsURL);
        resultJson.put("urlType", (MediaHelper.getMediaType(attachmentsVO.getContentType().split("/")[1]) == null) ? "0" : "1"); //0-일반, 1-이미지
        resultJson.put("f_seq", attachmentsVO.getSeq());

        return resultJson;
    }

    @RequestMapping(value = "file/{seq}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> file(@PathVariable("seq") long seq) throws IOException {
        InputStream in = null;
        ResponseEntity<byte[]> entity = null;

        AttachmentsVO attachmentsVO = new AttachmentsVO();
        try {
            attachmentsVO.setSeq(seq);
            attachmentsVO = attachmentsService.selectAttachments(attachmentsVO);

            String path = propertyHelper.getUploadPath() + attachmentsVO.getSave_path().replace("/","\\") + File.separator + attachmentsVO.getSave_name();

            MediaType mediaType = MediaHelper.getMediaType(attachmentsVO.getContentType().split("/")[1]);

            HttpHeaders httpHeaders = new HttpHeaders();

            in = new FileInputStream(path);

            if(mediaType != null) {
                httpHeaders.setContentType(mediaType);
            } else {
                httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                httpHeaders.add("Content-Disposition","attachment; filename=\"" + new String(attachmentsVO.getFilename().getBytes("UTF-8"), "ISO-8859-1")+"\"");
            }

            entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), httpHeaders, HttpStatus.CREATED);
        }
        catch (Exception ex)
        {
            new LogException(ex).printStackTrace();
            entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
        }finally{
            in.close();
        }
        return entity;
    }
    */
}
