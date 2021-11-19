<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Starting</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/header.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/userProfile.css">

</head>
<body style="background-color: #fafafa;">
	<jsp:include page="fragments/header.jsp"></jsp:include>
	<main>
		<div class="profile_boay">
			<div class="profile">
				<div class="profile_left">
					<div class="profile_imgbox">
						<div class="profile_imgbox1">
							<form action="" enctype="multipart/form-data" method="post"
								id="frm">
								<div class="filebox">
									<a href="userProfile"> <img src="${pageContext.request.contextPath}/resources/img/logo.png"
										class="rounded-circle" width="150" height="150"
										id="preview-image">
									</a>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="profile_right">
					<div class="profile_name">
						<h2 class="h2">coug_96</h2>
						<div class="profile_update">
							<a class="profile_update_button" href="message"
								tabindex="0">메시지 보내기</a>
						</div>
						<div class="profile_update">
							<a class="profile_update_button" href="profile_update"
								tabindex="0">프로필 편집</a>
						</div>
						<!-- 옵션 -->
						<svg id="option" onclick="#option" aria-label="옵션" class="_8-yf5 "
							color="#262626" fill="#262626" height="24" role="img"
							viewBox="0 0 48 48" width="24" style="padding: 20px;">
							<path clip-rule="evenodd"
								d="M46.7 20.6l-2.1-1.1c-.4-.2-.7-.5-.8-1-.5-1.6-1.1-3.2-1.9-4.7-.2-.4-.3-.8-.1-1.2l.8-2.3c.2-.5 0-1.1-.4-1.5l-2.9-2.9c-.4-.4-1-.5-1.5-.4l-2.3.8c-.4.1-.8.1-1.2-.1-1.4-.8-3-1.5-4.6-1.9-.4-.1-.8-.4-1-.8l-1.1-2.2c-.3-.5-.8-.8-1.3-.8h-4.1c-.6 0-1.1.3-1.3.8l-1.1 2.2c-.2.4-.5.7-1 .8-1.6.5-3.2 1.1-4.6 1.9-.4.2-.8.3-1.2.1l-2.3-.8c-.5-.2-1.1 0-1.5.4L5.9 8.8c-.4.4-.5 1-.4 1.5l.8 2.3c.1.4.1.8-.1 1.2-.8 1.5-1.5 3-1.9 4.7-.1.4-.4.8-.8 1l-2.1 1.1c-.5.3-.8.8-.8 1.3V26c0 .6.3 1.1.8 1.3l2.1 1.1c.4.2.7.5.8 1 .5 1.6 1.1 3.2 1.9 4.7.2.4.3.8.1 1.2l-.8 2.3c-.2.5 0 1.1.4 1.5L8.8 42c.4.4 1 .5 1.5.4l2.3-.8c.4-.1.8-.1 1.2.1 1.4.8 3 1.5 4.6 1.9.4.1.8.4 1 .8l1.1 2.2c.3.5.8.8 1.3.8h4.1c.6 0 1.1-.3 1.3-.8l1.1-2.2c.2-.4.5-.7 1-.8 1.6-.5 3.2-1.1 4.6-1.9.4-.2.8-.3 1.2-.1l2.3.8c.5.2 1.1 0 1.5-.4l2.9-2.9c.4-.4.5-1 .4-1.5l-.8-2.3c-.1-.4-.1-.8.1-1.2.8-1.5 1.5-3 1.9-4.7.1-.4.4-.8.8-1l2.1-1.1c.5-.3.8-.8.8-1.3v-4.1c.4-.5.1-1.1-.4-1.3zM24 41.5c-9.7 0-17.5-7.8-17.5-17.5S14.3 6.5 24 6.5 41.5 14.3 41.5 24 33.7 41.5 24 41.5z"
								fill-rule="evenodd"></path></svg>
					</div>
					<div class="profile_follow">
						<ul class="profile_list">
							<li class="profile_follow_"><span class="spaan">게시물</span><span
								class="sub_span">1</span></li>
							<li class="profile_follow_"><a class="spaan" href="follower">팔로워</a><span
								class="sub_span">14556</span></li>
							<li class="profile_follow_"><a class="spaan" href="follows">팔로우</a><span
								class="sub_span">12342</span></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="profile_info">
				<div></div>
				<div class="profile_info1">travel_behappyhere 해발 700m 산자락 위,
					프라이빗 캠핑 스팟💛 감탄을 자아내는 뷰와 함께 향긋한 메리골드 꽃차를 마시고, 밤이 되면 머리 위로 별이 쏟아지는
					곳✨ 산촌 생활의 불편함 그 자체가 매력적인 팜스테이를 즐기고 싶다면 추천드려요❣ 숙소 이름과 더 자세한 정보는,
					👉숙소기록: @rest_behappyhere 에서 확인해주세요! 📷이미지출처 @1amny @iam_eunz - ⠀
					여행 기록은 #여기서행복할것 태그♥ 여행 제보는 DM 또는 이메일로♥ ⠀ #여기서행복할것_국내 #behappyhere</div>
			</div>
			<div class="profile_board_body">

				<div class="profile_board">
					<a aria-selected="true" class="_9VEo1 T-jvg" role="tab" href=""
						tabindex="0"><span class="smsjF"><svg aria-label=""
								class="_8-yf5 " color="#262626" fill="#262626" height="24"
								role="img" viewBox="0 0 48 48" width="24">
							<path clip-rule="evenodd"
									d="M45 1.5H3c-.8 0-1.5.7-1.5 1.5v42c0 .8.7 1.5 1.5 1.5h42c.8 0 1.5-.7 1.5-1.5V3c0-.8-.7-1.5-1.5-1.5zm-40.5 3h11v11h-11v-11zm0 14h11v11h-11v-11zm11 25h-11v-11h11v11zm14 0h-11v-11h11v11zm0-14h-11v-11h11v11zm0-14h-11v-11h11v11zm14 28h-11v-11h11v11zm0-14h-11v-11h11v11zm0-14h-11v-11h11v11z"
									fill-rule="evenodd"></path></svg> </span> </a>
				</div>
				<div>
					<span class="PJXu4">게시물</span>
				</div>

			</div>
			<div class="profile_board_imgs">
				<div class="board_imgs">
					<div class="board_img">
						<img class="img" alt="1" src="${pageContext.request.contextPath}/resources/img/dm.png"><a
							href=""></a>
					</div>
					<div class="board_img">
						<img class="img" alt="1" src="${pageContext.request.contextPath}/resources/img/dm.png"> <a
							href=""></a>
					</div>
					<div class="board_img">
						<img class="img" alt="1" src="${pageContext.request.contextPath}/resources/img/dm.png"><a
							href=""></a>
					</div>
					<div class="board_img">
						<img class="img" alt="1" src="${pageContext.request.contextPath}/resources/img/dm.png"><a
							href=""></a>
					</div>
					<div class="board_img">
						<img class="img" alt="1" src="${pageContext.request.contextPath}/resources/img/dm.png"><a
							href=""></a>
					</div>
					<div class="board_img">
						<img class="img" alt="1" src="${pageContext.request.contextPath}/resources/img/dm.png"><a
							href=""></a>
					</div>
					<div class="board_img">
						<img class="img" alt="1" src="${pageContext.request.contextPath}/resources/img/dm.png"><a
							href=""></a>
					</div>
				</div>
			</div>

		</div>

	</main>

	<div class="RnEpo  Yx5HN " id="modal">
		<div class="pbNvD  fPMEg">
			<div class="_1XyCr  ">
				<div class="piCib">
					<div class="modal_button_body">
					<!-- 내정보 일경우 -->
						<button class="modal_button" tabindex="0" onclick="location.href='mypage'">개인정보 변경</button>
						<button class="modal_button" tabindex="0" onclick="location.href='board'">게시물 올리기</button>
						<button class="modal_button" tabindex="0" onclick="location.href='follower'">팔로워 확인</button>
						<button class="modal_button" tabindex="0" onclick="location.href='follws'">팔로우 확인</button>
						<button class="modal_button" tabindex="0" onclick="location.href='message'">message 확인</button>
						<button class="modal_button" tabindex="0" onclick="location.href='logout'">로그아웃</button>
						<button id="modal_cansle" class="modal_button" tabindex="0">취소</button>
					<!-- 상대방 정보 일경우 -->
						<button class="modal_button" tabindex="0" onclick="location.href='follower'">팔로우 하기</button>
						<button class="modal_button" tabindex="0" onclick="location.href='follows'">팔로우 취소</button>
						<button class="modal_button" tabindex="0" onclick="location.href='message'">message 보내기</button>
						<button class="modal_button" tabindex="0" onclick="location.href='declare'">신고하기</button>
						<button id="modal_cansle" class="modal_button" tabindex="0">취소</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script> 
const modal = document.querySelector('#modal'); 
const btnOpenPopup = document.getElementById('option');
btnOpenPopup.addEventListener('click', () => { 
	modal.style.display = 'block';
	});
const btnCansle = document.querySelector('#modal_cansle');
btnCansle.addEventListener('click', () => { 
	modal.style.display = 'none';
});	
</script>
</body>


</html>