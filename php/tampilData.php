<?php 

	//Mendapatkan Nilai Dari Variable id Pegawai yang ingin ditampilkan
	$id = $_GET['id'];
	
	//Importing database
	require_once('koneksi.php');
	
	//Membuat SQL Query dengan pegawai yang ditentukan secara spesifik sesuai id
	$sql = "SELECT * FROM tb_tagihan WHERE id=$id";
	
	//Mendapatkan Hasil 
	$r = mysqli_query($con,$sql);
	
	//Memasukkan Hasil Kedalam Array
	$result = array();
	$row = mysqli_fetch_array($r);
	array_push($result,array(
		"nama"=>$row['nama'],
		"ven"=>$row['vendor'],
		"tgl"=>$row['tanggal'],
		"tot"=>$row['total']
		
		));
 
	//Menampilkan dalam format JSON
	echo json_encode(array('result'=>$result));
	
	mysqli_close($con);