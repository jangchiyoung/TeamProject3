package com.jcpdev.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jcpdev.board.entity.ClientEntity;
import com.jcpdev.board.entity.FollowEntity;
import com.jcpdev.board.entity.HeartEntity;
import com.jcpdev.board.entity.WhiteboardEntity;
import com.jcpdev.board.model.Client;
import com.jcpdev.board.model.Heart;
import com.jcpdev.board.model.Whiteboard;
import com.jcpdev.board.repository.ClientRepository;
import com.jcpdev.board.repository.FollowRepository;
import com.jcpdev.board.repository.HeartRepository;
import com.jcpdev.board.repository.WhiteboardRepository;
import com.jcpdev.board.service.ClientService;
import com.jcpdev.board.service.FollowService;
import com.jcpdev.board.service.HeartService;
import com.jcpdev.board.service.WhiteboardService;

@Controller
public class WhiteboardController {

	// 20211118
	@Autowired
	WhiteboardRepository repository;

	@Autowired
	WhiteboardService service;

	@Autowired
	ClientRepository c_repository;

	@Autowired
	ClientService c_service;

	@Autowired
	FollowRepository f_repository;

	@Autowired
	FollowService f_service;

	@Autowired
	HeartRepository h_repository;
	@Autowired
	HeartService h_service;

	@RequestMapping({ "/starting/main", "/starting/", "/" })
	public String getList(Model model, HttpServletRequest request,String search_name) {
		Client user = (Client) request.getSession().getAttribute("client");
		List<Whiteboard> board_All_list = new ArrayList<Whiteboard>(); //
		List<Client> client_All_list = new ArrayList<Client>();
		List<Client> follow_list = new ArrayList<Client>();
		List<Client> not_follow_list = new ArrayList<Client>();
		List<Heart> likelist =  new ArrayList<Heart>();
		List<HeartEntity> likelist_et = h_repository.findByIdtoIdx(user.getClient_id());  
		List<WhiteboardEntity> board_All_list_et = repository.findByWhiteboard(user.getClient_id()); // ?????? ????????? ?????????
		List<ClientEntity> client_All_list_et = repository.findByUser(user.getClient_id()); // ?????? ?????? ?????????
		List<FollowEntity> follow_list_en = f_repository.findByMyFollow(user.getClient_id()); // ?????? ???????????? ?????????
		 for(ClientEntity c :client_All_list_et)
	            if(c.getClient_id().equals(search_name))
	               board_All_list_et = repository.findByWhiteboard_Client(search_name);

		// ?????? ????????? ?????????
		for (WhiteboardEntity temp : board_All_list_et) {
			board_All_list.add(service.toDto(temp));
		}
		// ?????? ????????? ??????  ?????????
		for (HeartEntity temp : likelist_et) {
			likelist.add( h_service.toDto(temp));
		}
		// ?????? ?????? ?????????
		for (ClientEntity temp : client_All_list_et) {
			client_All_list.add(c_service.toDto(temp));
		}
		// ?????? ???????????? ?????????
		for (FollowEntity temp : follow_list_en) {
			follow_list.add(c_service.toDto(c_repository.getById(f_service.toDto(temp).getFollowing_id())));
		}
		// ????????? ??????????????? ?????????
		boolean status = true; // ????????? ????????? ??????
		for (Client client : client_All_list) {
			for (Client follow : follow_list) {
				// ?????? ????????? ????????? ?????? ???????????? ???????????? ????????? ????????? ?????????
				if (client.getClient_id().equals(follow.getClient_id())) {
					status = false; // ?????? ??????
					break; // ????????? ??????
				} else {
					status = true;
				}
			}
			// ????????? ????????? ?????? ????????? ???????????? ?????? ?????? ??????????????? ??? ?????????????????? ???????????????
			if (status && !(client.getClient_id().equals(user.getClient_id()))) {
				not_follow_list.add(client); // ??????
			}
		}
		
		System.out.println(likelist);
		model.addAttribute("likelist", likelist); // ?????? ?????? ?????????
		model.addAttribute("client_All_list", client_All_list); // ?????? ?????? ?????????
		model.addAttribute("follow_list", follow_list); // ?????? ???????????? ?????????
		model.addAttribute("board_All_list", board_All_list); // ?????? ????????? ?????????
		model.addAttribute("not_follow_list", not_follow_list); // ????????? ??????????????? ?????????
		return "starting";
	}

	// ????????? ?????????
	@RequestMapping(value = "/starting/board", method = RequestMethod.POST)
	public String insert(@RequestParam MultipartFile whiteboard_img1, @RequestParam MultipartFile whiteboard_img2,
			@RequestParam MultipartFile whiteboard_img3, String whiteboard_client_id, String whiteboard_content)
			throws IllegalStateException, IOException {
		System.out.println(whiteboard_img1.getOriginalFilename());
		System.out.println(whiteboard_img2.getOriginalFilename());
		System.out.println(whiteboard_img3.getOriginalFilename());

		String randomimg1 = null, randomimg2 = null, randomimg3 = null;
		if (!whiteboard_img1.isEmpty())
			randomimg1 = UUID.randomUUID().toString() + whiteboard_img1.getOriginalFilename();
		if (!whiteboard_img2.isEmpty())
			randomimg2 = UUID.randomUUID().toString() + whiteboard_img2.getOriginalFilename();
		if (!whiteboard_img3.isEmpty())
			randomimg3 = UUID.randomUUID().toString() + whiteboard_img3.getOriginalFilename();

		Whiteboard whiteboard = new Whiteboard(0, whiteboard_client_id, randomimg1, randomimg2, randomimg3,
				whiteboard_content, null, 0, 0);

		String path = "C:\\img\\test";
		File upfile = null;
		if (randomimg1 != null) {
			String img = path + "\\" + randomimg1;
			upfile = new File(img);
			whiteboard_img1.transferTo(upfile);
		}
		if (randomimg2 != null) {
			String img = path + "\\" + randomimg2;
			upfile = new File(img);
			whiteboard_img2.transferTo(upfile);
		}
		if (randomimg3 != null) {
			String img = path + "\\" + randomimg3;
			upfile = new File(img);
			whiteboard_img3.transferTo(upfile);
		}

		System.out.println(whiteboard);
		WhiteboardEntity entity = service.toEntity(whiteboard);
		System.out.println(entity);
		repository.save(entity);
		return "redirect:/starting/main?client_id=" + whiteboard_client_id;
	}

	@RequestMapping(value = "/starting/board", method = RequestMethod.GET)
	public String board() {
		return "board";
	}

	@RequestMapping(value = "/starting/update", method = RequestMethod.GET)
	public String updateView(int whiteboard_no, Model model) {
		WhiteboardEntity entity = repository.findById(whiteboard_no).get();
		Whiteboard dto = service.toDto(entity);
		model.addAttribute("board", dto);

		return "boardUpdate";
	}

	@RequestMapping(value = "/starting/update", method = RequestMethod.POST)
	public String update(@RequestParam MultipartFile whiteboard_img1, @RequestParam MultipartFile whiteboard_img2,
			@RequestParam MultipartFile whiteboard_img3, String whiteboard_content, String whiteboard_client_id,
			int whiteboard_no, int whiteboard_count, int whiteboard_like, Model model)
			throws IllegalStateException, IOException {
		System.out.println("??????????????????.");
		System.out.println(whiteboard_img1.getOriginalFilename());

		WhiteboardEntity entity = repository.findById(whiteboard_no).get();

		String randomimg1 = null, randomimg2 = null, randomimg3 = null;

		if (!whiteboard_img1.isEmpty())
			randomimg1 = UUID.randomUUID().toString() + whiteboard_img1.getOriginalFilename();
		if (!whiteboard_img2.isEmpty())
			randomimg2 = UUID.randomUUID().toString() + whiteboard_img2.getOriginalFilename();
		if (!whiteboard_img3.isEmpty())
			randomimg3 = UUID.randomUUID().toString() + whiteboard_img3.getOriginalFilename();

		String path = "C:\\img\\test";
		File upfile = null;
		if (randomimg1 != null) {
			String img = path + "\\" + randomimg1;
			upfile = new File(img);
			whiteboard_img1.transferTo(upfile);
		}
		if (randomimg2 != null) {
			String img = path + "\\" + randomimg2;
			upfile = new File(img);
			whiteboard_img2.transferTo(upfile);
		}
		if (randomimg3 != null) {
			String img = path + "\\" + randomimg3;
			upfile = new File(img);
			whiteboard_img3.transferTo(upfile);
		}

		Whiteboard whiteboard = new Whiteboard(whiteboard_no, whiteboard_client_id, randomimg1, randomimg2, randomimg3,
				whiteboard_content, null, whiteboard_count, whiteboard_like);

		entity = service.toEntity(whiteboard);
		repository.save(entity);

		System.out.println(whiteboard_img1);
		return "redirect:/starting/main?client_id=" + whiteboard_client_id;
	}

	@RequestMapping("/starting/delete")
	public String delete(int whiteboard_no) {
		repository.deleteById(whiteboard_no);
		return "redirect:/starting/main";
	}

	@ResponseBody
	@RequestMapping(value = "/heart", method = RequestMethod.POST)
	public JSONObject heart(@RequestBody JSONObject no, HttpServletRequest request) {
		String temp = (String) no.get("no");
		int num = Integer.parseInt(temp);
		List<Heart> heart_list = new ArrayList<Heart>();
		List<HeartEntity> h_entity = h_repository.findByBoardNo(num);
		for (HeartEntity h : h_entity)
			heart_list.add(h_service.toDto(h));

		HttpSession session = request.getSession();
		Client user = (Client) session.getAttribute("client");

		int cnt = service.toDto(repository.getById(num)).getWhiteboard_like();
		boolean check = true;
		Heart test = null;

		for (Heart h : heart_list) {
			test = h;
			if (h.getC_heart_client_id().equals(user.getClient_id())) {
				check = false; // ??? ??????
				break;
			}
		}

		if (check) {
			// ??????
			h_repository.save(h_service.toEntity(Heart.builder().w_heart_whiteboard_no(num)
					.c_heart_client_id(user.getClient_id()).heart_no(0).build()));
			repository.updateLike(num);
			cnt++;
		} else {
			h_repository.delete(h_service.toEntity(test));
			repository.updateLike(num);
			cnt--;
		}

		JSONObject data = new JSONObject();
		data.put("idx", temp);
		data.put("like", String.valueOf(cnt));
		return data;
	}

}