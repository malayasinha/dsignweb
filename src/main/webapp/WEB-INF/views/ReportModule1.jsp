<div class="container" ng-controller="reportmod1Controller"
	ng-init="showLink=false; showSpinner=false;showMessage=false;">
	<div class="card text-center mt-2">
		<div class="card-header">
			<h3 class="text-center">Report - Phase I</h3>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">
					<form>
						<div class="row">
							<div class="col-md-3">
								<label for="fromDate">From Date:</label> <input type="date"
									id="fromDate" name="fileName" ng-model="fromDate"></input>
							</div>
							<div class="col-md-3">
								<label for="toDate">To Date:</label> <input type="date"
									id="toDate" name="toName" data-ng-model="toDate" required></input>
							</div>
							<div class="col-md-3">
								<div style="vertical-align: top;">
									<button class="btn btn-secondary mt-4" ng-click="btnSearch()">Search</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="card text-center" ng-show="showLink">
		<div class="card-body">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>DownLoad Result</th>
						<th>Click Here</th>

					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="(k,v) in downloads">
						<td>{{k}}</td>
						<td><a href="/dsign/download1/{{v}}" download> <i
								class="fa fa-download" style="font-size: 30px; color: green"></i>
						</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="card text-center" ng-show="showSpinner">
		<div class="card-body">
			<div class="spinner-border text-muted"></div>
		</div>
	</div>
	<div class="card text-center" ng-show="showMessage">
		<div class="card-body">
			<div class="alert alert-danger">
				<strong>Message!</strong> Data does not exist.
			</div>
		</div>
	</div>
</div>

