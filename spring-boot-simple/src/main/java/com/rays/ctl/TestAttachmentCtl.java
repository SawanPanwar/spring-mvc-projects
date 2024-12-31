package com.rays.ctl;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rays.common.ORSResponse;
import com.rays.dto.AttachmentDTO;
import com.rays.service.AttachmentService;

@RestController
@RequestMapping(value = "TestAttachmentCtl")
public class TestAttachmentCtl {

	@Autowired
	public AttachmentService attachmentService;

	@PostMapping("/profilePic/{userId}")
	public ORSResponse uploadPic(@PathVariable Long userId, @RequestParam("file") MultipartFile file,
			HttpServletRequest req) {

		AttachmentDTO attachmentDto = new AttachmentDTO(file);

		attachmentDto.setDescription("profile pic");

		attachmentDto.setUserId(userId);

		Long imageId = attachmentService.save(attachmentDto);

		ORSResponse res = new ORSResponse();

		res.addResult("imageId", imageId);

		return res;
	}

	@GetMapping("/profilePic/{imageId}")
	public void downloadPic(@PathVariable Long imageId, HttpServletResponse response) {

		try {

			AttachmentDTO attachmentDTO = null;

			attachmentDTO = attachmentService.findById(imageId);

			if (attachmentDTO != null) {
				response.setContentType(attachmentDTO.getType());
				OutputStream out = response.getOutputStream();
				out.write(attachmentDTO.getDoc());
				out.close();
			} else {
				response.getWriter().write("ERROR: File not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
