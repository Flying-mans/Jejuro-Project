
window.addEventListener("scroll",function(){
	
	var nextBtn = document.querySelector(".next-btn");
	var main = document.querySelector(".main");
	var mainHeight = this.document.querySelector("main");

	// let isUpdateList = true;
	const currentScroll = window.scrollY;
	const paddingBottom = 600;
	
	if(currentScroll + paddingBottom >= mainHeight.offsetHeight){


		isUpdateList = false;

		fetch(
			`api/posts/${nextBtn.value}`,{method:"get"})
			.then((resp => resp.json()))
			.then(data =>{
				for(let m of data){
					let template = `
				<div class="main">
					<section class="board-item">
						<a href="post/${m.post_id}">
							<form>
								<h1 class="board-item-h1">${m.title}</h1>
								<span class="date">${m.reg_date}</span>
								<span class="reply-count">댓글 : 3</span>
								<span class="hits">조회수 : ${m.view_count}</span>
							</form>        
						</a>
					</section>
				</div>
					`;
					main.insertAdjacentHTML("afterend", template);	
					main = main.parentElement.lastElementChild;
				};
			});
		nextBtn.value ++;
	}	
});