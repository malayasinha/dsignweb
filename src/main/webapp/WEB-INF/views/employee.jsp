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
<div class="container" ng-controller="profileController"
	ng-init="showLink=false; showSpinner=false; showMessage=false;">
	<div class="card text-center mt-2">
		<div class="card-header">
			<h3 class="text-center">Create Profile</h3>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">
					<form>
						<div class="row">
							<div class="col-md-6">
								<label for="profileName">Profile Name</label> 
								<input type="text" id="profileName" name="profileName" ng-model="p.profileName" style="width=100em">
								</input>
							</div>
							<div class="col-md-6">
								<label for="documentType">Document Type</label> 
								<select id="documentType" name="documentType" ng-model="p.documentType" style="width=100em" >
									<option value="">Select</option>
									<option ng-repeat="doc in doclist" value="{{doc}}">{{doc}}</option>
								</select>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label for="signatory1">Signatory 1</label> 
								<select id="signatory1" name="signatory1" ng-model="p.signatory1" style="width=100em">
									<option value="">Select</option>
									<option ng-repeat="(key,value) in signlist" value="{{key}}">{{value}}</option>
								</select>
							</div>
							<div class="col-md-6">
								<label for="signatory2">Signatory 2</label> 
								<select id="signatory2" name="signatory2" ng-model="p.signatory2" style="width=100em">
									<option value="">Select</option>
									<option ng-repeat="(key,value) in signlist" value="{{key}}">{{value}}</option>
								</select>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label for="signatory3">Signatory 3</label> 
								<select id="signatory3" name="signatory3" ng-model="p.signatory3" style="width=100em">
									<option value="">Select</option>
									<option ng-repeat="(key,value) in signlist" value="{{key}}">{{value}}</option>
								</select>
							</div>
							<div class="col-md-6">
								<label for="signatory4">Signatory 4</label> 
								<select id="signatory4" name="signatory4" ng-model="p.signatory4" style="width=100em">
									<option value="">Select</option>
									<option ng-repeat="(key,value) in signlist" value="{{key}}">{{value}}</option>
								</select>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label for="signatory5">Signatory 5</label> 
								<select id="signatory5" name="signatory5" ng-model="p.signatory5" style="width=100em">
									<option value="">Select</option>
									<option ng-repeat="(key,value) in signlist" value="{{key}}">{{value}}</option>
								</select>
							</div>
							
						</div>
					</form>
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
			                	<button class="btn btn-secondary mt-4" ng-click="btnSave()">Save</button>
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
