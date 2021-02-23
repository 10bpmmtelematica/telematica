<?php 

	//getting the dboperation class
	require_once '/DbOperation.php';

	//function validating all the paramters are available
	//we will pass the required parameters to this function 
	function isTheseParametersAvailable($params){
		//assuming all parameters are available 
		$available = true; 
		$missingparams = ""; 
		
		foreach($params as $param){
			if(!isset($_POST[$param]) || strlen($_POST[$param])<=0){
				$available = false; 
				$missingparams = $missingparams . ", " . $param; 
			}
		}
		
		//if parameters are missing 
		if(!$available){
			$response = array(); 
			$response['error'] = true; 
			$response['message'] = 'Parameters ' . substr($missingparams, 1, strlen($missingparams)) . ' missing';
			
			//displaying error
			echo json_encode($response);
			
			//stopping further execution
			die();
		}
	}
	
	//an array to display response
	$response = array();
	
	//if it is an api call 
	//that means a get parameter named api call is set in the URL 
	//and with this parameter we are concluding that it is an api call
	if(isset($_GET['g'])){
		
		switch($_GET['g']){
			
			//the CREATE operation
			//if the api call value is 'createhero'
			//we will create a record in the database
			case 'createmat':
				//first check the parameters required for this request are available or not 
				isTheseParametersAvailable(array('codigo', 'tipo', 'subtipo', 'descricao', 'qtd', 'data'));
				
				//creating a new dboperation object
				$db = new DbOperation();
				
				//creating a new record in the database
				$result = $db->createMat(
					$_POST['codigo'],
					$_POST['tipo'],
					$_POST['subtipo'],
					$_POST['descricao'],
					$_POST['qtd'],
					$_POST['data']
				);
				

				//if the record is created adding success to response
				if($result){
					//record is created means there is no error
					$response['error'] = false; 

					//in message we have a success message
					$response['message'] = 'Material Adicionado com Sucesso!';

					//and we are getting all the heroes from the database in the response
					$response['materiais'] = $db->getMat();
				}else{

					//if record is not added that means there is an error 
					$response['error'] = true; 

					//and we have the error message
					$response['message'] = 'Erro!!! tente novamente';
				}
				
			break; 
			
			//the READ operation
			//if the call is getheroes
			case 'getmat':
				$db = new DbOperation();
				$response['error'] = false; 
				$response['message'] = 'Requerimento completo com sucesso';
				$response['materiais'] = $db->getMat();
			break; 
			
			
			//the UPDATE operation
			case 'updatemat':
				isTheseParametersAvailable(array('id','codigo', 'tipo', 'subtipo', 'descricao', 'qtd', 'data'));
				$db = new DbOperation();
				$result = $db->updateMat(
					$_POST['id'],
					$_POST['codigo'],
					$_POST['tipo'],
					$_POST['subtipo'],
					$_POST['descricao'],
					$_POST['qtd'],
					$_POST['data']
				);
				
				if($result){
					$response['error'] = false; 
					$response['message'] = 'Material atualizado com sucesso';
					$response['materiais'] = $db->getMat();
				}else{
					$response['error'] = true; 
					$response['message'] = 'Erro!!! tente novamente';
				}
			break; 
			
			//the delete operation
			case 'deletemat':

				//for the delete operation we are getting a GET parameter from the url having the id of the record to be deleted
				if(isset($_GET['id'])){
					$db = new DbOperation();
					if($db->deleteMat($_GET['id'])){
						$response['error'] = false; 
						$response['message'] = 'Material deletado com sucesso';
						$response['materiais'] = $db->getMat();
					}else{
						$response['error'] = true; 
						$response['message'] = 'Erro!!! tente novamente';
					}
				}else{
					$response['error'] = true; 
					$response['message'] = 'Não deletado, digite o ID';
				}
			break; 
			
			case 'buscamat':
			

				//for the delete operation we are getting a GET parameter from the url having the id of the record to be deleted
				if(isset($_GET['codigo'])){
					$db = new DbOperation();
					if($db->buscaMat($_GET['codigo'])){
						$response['error'] = false; 
						$response['message'] = 'Material buscado com sucesso';
						$response['materiais'] = $db->getMat();
					}else{
						$response['error'] = true; 
						$response['message'] = 'Erro!!! tente novamente';
					}
				}else{
					$response['error'] = true; 
					$response['message'] = 'Não buscado digite o codigo';
				}
			break; 
		}
		
	}else{
		//if it is not api call 
		//pushing appropriate values to response array 
		$response['error'] = true; 
		$response['message'] = 'Invalid API Call';
	}
	
	//displaying the response in json structure 
	echo json_encode($response);
	
	
