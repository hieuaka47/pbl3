
$(document).ready(function() {
	var mark = "";
	$(".col-name-tour").click(function(event) {
		event.preventDefault();

		var col = $(this).attr("class").split(" ")[2];
		var mode = $(this).attr("class").split(" ")[3];

		if (mark != $(this).attr("id")) {
			$(".col-name").children(".fa-sort-up").css("color", "");
			$(".col-name").children(".fa-sort-down").css("color", "");
		}

		mark = $(this).attr("id");

		if (mode == "asc") {
			$(this).children(".fa-sort-up").css("color", "#3498DB");
			$(this).children(".fa-sort-down").css("color", "");
			$(this).removeClass("asc").addClass("desc");
		} else {
			$(this).children(".fa-sort-down").css("color", "#3498DB");
			$(this).children(".fa-sort-up").css("color", "");
			$(this).removeClass("desc").addClass("asc");
		}
		$.ajax({
			url: 'table_tour_handel',
			type: 'GET',
			data: {
				col: col,
				mode: mode
			},
			success: function(data) {
				$("#content-tour-table").html(data);

			}
		})
	});

});