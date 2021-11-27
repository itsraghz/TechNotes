# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 45 \
27 Nov 2021 Sat \
7 10 AM IST - 8 15 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Spring Boot Web MVC JPA MySQL - Mini Project - Part 03

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDM3ODExMzYxMTAz/details

```
						Date : 27-11-2021
						Spring Boot 7AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
Task: Spring AOP
https://www.youtube.com/watch?v=x2f4NzNCkCI
https://www.youtube.com/watch?v=8DG-J8_WfUE

--------------------
9AM
ID : 97674169818
Pwd: 536193
--------------------

      			Spring Boot Web MVC + AJAX

*) By using AJAX client machine can submit partial page data for process.
*) AJAX calls never reload entire pages.
*) AJAX stands for Asynchronous JavaScript And XML

---Code----------------------
1. Custom Query at Repository

@Query("SELECT COUNT(E.empMail) FROM Employee E  WHERE E.empMail=:empMail")
Integer getEmployeeMailCount(String empMail);

2. Service method returns boolean

boolean isEmployeeMailExist(String empMail);

3. At ServiceImpl  count>0

	public boolean isEmployeeMailExist(String empMail) {
		Integer count = repo.getEmployeeMailCount(empMail);
		boolean exist = count > 0 ? true : false ;
		return exist;
		//return repo.getEmployeeMailCount(empMail)>0;
	}

4. Define method in controller that check
	given email exist or not?
  if exist return message.


	@GetMapping("/validate")
	@ResponseBody
	public String validateMail(
			@RequestParam("email") String empMail
			)
	{
		String message = "";
		if(service.isEmployeeMailExist(empMail)) {
			message = empMail+", already exist!";
		}

		return message;
	}


5. UI - Write AJAX code on change input and on submit.


MAIL : <input type="text" name="empMail" id="empMail" class="form-control"> <div id="empMailError"></div>

	<script>
		$(document).ready(function(){
			$("#empMailError").hide();
			var empMailError = false;

			function validate_empMail() {
				var val = $("#empMail").val();
				var exp = /^[A-Za-z0-9\.\-\_]+\@[a-z]+\.[a-z\.]{2,8}$/;
				if(val=='') {
					$("#empMailError").show();
					$("#empMailError").html("<b>EMAIL </b> CAN NOT BE EMPTY!");
					$("#empMailError").css('color','red');
					empMailError = false;
				} else if(!exp.test(val)) {
					$("#empMailError").show();
					$("#empMailError").html("<b>EMAIL </b> IS NOT VALID");
					$("#empMailError").css('color','red');
					empMailError = false;
				} else {
					//AJAX call
					$.ajax({
						url : 'validate',
						data: {"email":val},
						success:function(respTxt) {
							if(respTxt!='') {
								$("#empMailError").show();
								$("#empMailError").html(respTxt);
								$("#empMailError").css('color','red');
								empMailError = false;
							} else {
								$("#empMailError").hide();
								empMailError = true;
							}
						}
					})
					//END-AJAX
				}
				return empMailError;
			}

			$("#empMail").keyup(function(){
				validate_empMail();
			})

			//on submit
			$("#myRegForm").submit(function(){
				validate_empMail();
				if(empMailError) return true ;// submit form to server
				else return false; //do not submit form
			});

		});
	</script>

6. Add JQuery Link at UI Page
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>

*) Note:
a. AJAX call also HTTP Request.
b. It needs 3 inputs: URL, DATA and Success:function
c. URL and data are used to make request to server
   URL?data    ex:
     http://localhost:8080/employee/validate?email=sam%40gmail.com
d. success:function  is executed once response comes back to ajax.

e. Additional Links:-
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js"></script>

=========================================================================
