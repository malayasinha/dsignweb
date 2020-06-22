<style>
.main-content{
		min-height: 200px;
        //background: #dbdfe5;
    }
    .sidebar-content{
        min-height: 70px;
        margin-bottom: 5px;
        //background: #b4bac0;
    }
</style>
<div class="container" ng-controller="searchmod1Controller"
	ng-init="showLink=false; showSpinner=false; showMessage=false;">
	<div class="card text-center mt-2">
		<div class="card-header">
			<h3 class="text-center">Search - Phase I</h3>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-sm-8">
					<div class="main-content">
					<label for="fileName">Comma Seperated File Names:</label>
							<textarea id="fileName" name="fileName" ng-model="fileName"
								rows="4" cols="50" required></textarea>
					</div>
				</div>
		        <div class="col-sm-4">
		            <!--Column right with nested rows and columns-->
		            <div class="row">
		                <div class="col-12">
		                	<div class="sidebar-content"></div>
		                </div>
		            </div>
		            <div class="row">
		                <div class="col-6">
			                <div class="sidebar-content">
			                	<button class="btn btn-secondary mt-4" ng-click="btnSearch()">Search</button>
			                </div>
		                </div>
		                <div class="col-6"><div class="sidebar-content"></div></div>
		            </div>
		        </div>
			</div>
		</div>
	</div>

	<div class="card text-center" ng-show="showLink">
		<div class="card-body">
			<table class="table table-bordered" >
					<tr>
						<th>Download Result</th>
						<th>Link</th>
					</tr>
					<tr ng-repeat="(k,v) in downloads">
						<td>{{k}}</td>
						<td><a href="/dsign/download1/{{v}}" download> <i
								class="fa fa-download" style="font-size: 30px; color: green"></i>
						</a></td>
					</tr>
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
			  <strong>Message!</strong> {{message}}
			</div>
		</div>
	</div>
</div>
