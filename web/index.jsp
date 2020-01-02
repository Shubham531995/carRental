<html>
<head>
  Car Rental
  <script src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script>
    $(document).on("submit", "#submit", function() {
      var location=$('#location').val();
      var date=$('#date').val();
      $.get("/avaialable", {location:location, date:date},function(responseText) {
        $("#somediv").text(responseText);
      });
    });
  </script>
</head>
<body>
<form action ="avaialable" method="post">
  <p>Location:
    <input type="text" name="location" id="location"/></p>
  <p>Date:
    <input type="text" name="date" id="date"/></p>
  <p>Submit
    <input type="submit" name="submit" value="submit" /></p>
</form>
<strong>Ajax Response</strong>:
<div id="somediv"></div>
</body>
</html>