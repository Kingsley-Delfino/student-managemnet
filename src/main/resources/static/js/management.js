var addStudent = function(studentId, name, department, major) {
    var json = {"studentId": studentId, "name" : name, "department" : department, "major" : major};
	$.ajax({
		type: "POST",
		url: "/api/v1/student",
        data: JSON.stringify(json),
        contentType: "application/json",
        dataType: "json",
		success: function(result) {
			console.log(result);
			if(result) {
				alert("添加成功！");
			}
			else {
				alert("添加失败！");
			}
		}
	})
}

var showStudents = function() {
	$("#show").html("");
	$.ajax({
		type: "GET",
		url: "/api/v1/student",
		success: function(result) {
			console.log(result);
			var html = "<table class='table table-bordered' style='margin: auto; font-size: x-large'>";
			html += "<tr><th>index</th><th>studentId</th><th>name</th><th>department</th><th>major</th></tr>";
			var tr = function(index, student) {
				html += "<tr>";
				html += "<th>";
				html += index;
				html += "</th>";
				html += "<th>";
				html += student.studentId;
				html += "</th>";
				html += "<th>";
				html += student.name;
				html += "</th>";
				html += "<th>";
				html += student.department;
				html += "</th>";
				html += "<th>";
				html += student.major;
				html += "</th>";
				html += "</tr>";
			}
			for(var i = 0; i < result.length; i ++) {
				tr(i+1, result[i]);
			}
			html += "</table>"
			$("#show").html(html);
		}
	})
}

var changeStudent = function (studentId, name, department, major) {
	var json = {"studentId": studentId, "name" : name, "department" : department, "major" : major};
	$.ajax({
		type: "PUT",
		url: "/api/v1/student",
		data: JSON.stringify(json),
		contentType: "application/json",
		dataType: "json",
		success: function(result) {
			console.log(result);
			if(result) {
				alert("修改成功！");
			}
			else {
				alert("修改失败！");
			}
		}
	})
}

var deleteStudent = function (studentId) {
	var json = {"studentId": studentId};
	$.ajax({
		type: "DELETE",
		url: "/api/v1/student",
		data: JSON.stringify(json),
		contentType: "application/json",
		dataType: "json",
		success: function(result) {
			console.log(result);
			if(result) {
				alert("删除成功！");
			}
			else {
				alert("删除失败！");
			}
		}
	})
}