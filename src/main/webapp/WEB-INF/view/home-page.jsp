<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
	<head>
		<link rel="stylesheet" href="/css/styles.css"/>
		<link rel="stylesheet" href="/css/materialize.min.css"/>
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	</head>
	<body>
		<div class="center">
			<div class="main_headline">
				<div class="color-red">SMART-4-AVIATION</div>
			</div>
			
			<c:if test="${flightId != null}">
				<div class="info-style">
					
					<div class="info-headline">
						Weight Calculation for Flight
					</div>
					
					<c:choose>
						<c:when test="${flightId == 'Flight not found !!'}">
							<span class="info">
								Flight not found !!
							</span>
						</c:when>
						<c:otherwise>
							<span class="info">
								Cargo Weight = <span class="font-300">${cargoWeight} kg</span><br>
								Baggage Weight = <span class="font-300">${baggageWeight} kg</span><br>
								Total Weight = <span class="font-300">${totalWeight} kg</span>
							</span>
						</c:otherwise>
					</c:choose>
					
					<br><br>
					
					<div class="info-headline">
						Flight & Baggage Count for Airport
					</div>
					<span class="info">
						Total Flights Departing = <span class="font-300">${totalFlightsDeparting}</span> <br>
						Total Flights Arriving = <span class="font-300">${totalFlightsArriving}</span> <br>
						Total Baggage Pieces Arriving = <span class="font-300">${totalBaggagePiecesArriving}</span> <br>
						Total Baggage Pieces Departing = <span class="font-300">${totalBaggagePiecesDeparting}</span> <br>
					</span>
				</div>
			</c:if>
			
			<form:form action="processCalculation" method="get" modelAttribute="calculation">
				<div class="row">
					<div class="col m1 offset m4 margin-top-30">
						<div class="card-panel teal accent-2">
							<div class="card-content center">
								<h3 class="font-size-40">Weight Calculation for Flight</h3>
							    <div class="input-field">
							    	<i class="material-icons prefix">flight</i>
							    	<form:input id="requestedFlightNumber" class="" path="requestedFlightNumber"/>
							    	<label for="requestedFlightNumber">Flight Number</label>
							    	<form:errors path="requestedFlightNumber" class="error"/>
							    </div>
							    <div class="input-field">
							    	<i class="material-icons prefix">today</i>
							    	<form:input id="requestedFlightDate" class="datepicker" path="requestedFlightDate"/>
							     	<label for="requestedFlightDate">Date</label>
							     	<form:errors path="requestedFlightDate" class="error"/>
							    </div>
							</div>
						</div>
					</div>
					<div class="col m1 offset m4 margin-top-30" id="float-right">
						<div class="card-panel light-green accent-3">
							<div class="card-content center">
								<h3 class="font-size-40">Flight & Baggage Count for Airport</h3>
							    <div class="input-field">
							    	<i class="material-icons prefix">flight</i>
							    	<form:input id="requestedAirportCode" class="uppercase" path="requestedAirportCode"/>
							    	<label for="requestedAirportCode">IATA Airport Code</label>
							    	<form:errors path="requestedAirportCode" class="error"/>
							    </div>
							    <div class="input-field">
							    	<i class="material-icons prefix">today</i>
							    	<form:input id="requestedAirportDate" class="datepicker" path="requestedAirportDate"/>
							     	<label for="requestedAirportDate">Date</label>
							     	<form:errors path="requestedAirportDate" class="error"/>
							    </div>
							</div>
						</div>
					</div>
				</div>
				<input type="submit" class="custom-button" value="Calculate"/>
			</form:form>
		</div>
		
		<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
		
		<script>
			const calendar = document.querySelectorAll('.datepicker');
			M.Datepicker.init(calendar, {
				format: 'yyyy-mm-dd',
				maxDate: new Date(),
				yearRange: 20
			});
		</script>
	</body>
</html>