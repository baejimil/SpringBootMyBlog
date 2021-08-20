let index = {
	init: function() {
		$("#btn-save").on("click", () => {
			this.save();
		});
		$("#btn-update").on("click", () => {
			this.update();
		});
	},

	save: function() {
		// alert('user의 save함수 호출됨');
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val(),
		};


		// console.log(data);

		$.ajax({
			type: "POST",  // 요청할 타입
			url: "/auth/joinProc",  // 호출할 주소
			data: JSON.stringify(data),	// data를 json화 시키는 문법
			contentType: "application/json; charset=utf-8", // Body data가 어떤 타입인지 , 위아래 세트!
			dataType: "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열(생긴게 json이라면) => javascript오브젝트로 변경
		}).done(function(resp) {
			alert("회원가입이 완료되었습니다");
			//console.log(resp);
			location.href = "/";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		}); // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청!!
	},
	
	update: function() {
		let data = {
			id: $("#id").val(),
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val(),
		};


		// console.log(data);

		$.ajax({
			type: "PUT",  // 요청할 타입
			url: "/user",  // 호출할 주소
			data: JSON.stringify(data),	// data를 json화 시키는 문법
			contentType: "application/json; charset=utf-8", // Body data가 어떤 타입인지 , 위아래 세트!
			dataType: "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열(생긴게 json이라면) => javascript오브젝트로 변경
		}).done(function(resp) {
			alert("회원수정이 완료되었습니다");
			//console.log(resp);
			location.href = "/";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		}); // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청!!
	}, 
}
index.init();