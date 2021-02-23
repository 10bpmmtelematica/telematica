<?php
 
class DbOperation
{
    //Database connection link
    private $con;
 
    //Class constructor
    function __construct()
    {
        //Getting the DbConnect.php file
        require_once dirname(__FILE__) . '/DbConnect.php';
 
        //Creating a DbConnect object to connect to the database
        $db = new DbConnect();
 
        //Initializing our connection link of this class
        //by calling the method connect of DbConnect class
        $this->con = $db->connect();
    }
	
	/*
	* The create operation
	* When this method is called a new record is created in the database
	*/
	function createMat($codigo, $tipo, $subtipo, $descricao, $qtd, $data){
		$stmt = $this->con->prepare("INSERT INTO materiais (codigo, tipo, subtipo, descricao, qtd, data) VALUES (?, ?, ?, ?, ?, ?)");
		$stmt->bind_param("ssssss", $codigo, $tipo, $subtipo, $descricao, $qtd, $data);
		if($stmt->execute())
			return true; 
		return false; 
	}

	/*
	* The read operation
	* When this method is called it is returning all the existing record of the database
	*/
	function getMat(){
		$stmt = $this->con->prepare("SELECT id, codigo, tipo, subtipo, descricao, qtd, data FROM materiais");
		$stmt->execute();
		$stmt->bind_result($id, $codigo, $tipo, $subtipo, $descricao, $qtd, $data);
		
		$materiais = array(); 
		
		while($stmt->fetch()){
			$mat  = array();
			$mat['id'] = $id; 
			$mat['codigo'] = $codigo; 
			$mat['tipo'] = $tipo; 
			$mat['subtipo'] = $subtipo; 
			$mat['descricao'] = $descricao; 
			$mat['qtd'] = $qtd;
			$mat['data'] = $data;
			
			array_push($materiais, $mat); 
		}
		
		return $materiais; 
	}
	
	/*
	* The update operation
	* When this method is called the record with the given id is updated with the new given values
	*/
	function updateMat($id, $codigo, $tipo, $subtipo, $descricao, $qtd, $data){
		$stmt = $this->con->prepare("UPDATE materiais SET codigo = ?, tipo = ?, subtipo = ?, descricao = ?, qtd = ?, data = ? WHERE id = ?");
		$stmt->bind_param("ssssssi", $codigo, $tipo, $subtipo, $descricao, $qtd, $data, $id);
		if($stmt->execute())
			return true; 
		return false; 
	}
	
	
	/*
	* The delete operation
	* When this method is called record is deleted for the given id 
	*/
	function deleteMat($id){
		$stmt = $this->con->prepare("DELETE FROM materiais WHERE id = ? ");
		$stmt->bind_param("i", $id);
		if($stmt->execute())
			return true; 
		
		return false; 
	}
	
	function buscaMat($codigo){
		$stmt = $this->con->prepare("UPDATE materiais SET tipo = ?, subtipo = ?, descricao = ?, qtd = ?, data = ?, id = ? WHERE codigo = ? ");
		$stmt->bind_param("sssssis", $codigo, $tipo, $subtipo, $descricao, $qtd, $data, $id);
		if($stmt->execute())
			return true; 
		return false; 
	}
}