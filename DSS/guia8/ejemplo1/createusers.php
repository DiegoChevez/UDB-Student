<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8" />
<title>Autenticación de usuarios</title>
</head>
<body>
<section>
<article>
<?php
if(isset($_POST['user']) && isset($_POST['pass'])){
$pwfile = fopen("users.txt", "a");
fputs($pwfile, $_POST['user'] . ":" . crypt($_POST['pass'], "pw") . "\n");
fclose($pwfile);
?>
Usuario
<?php
echo htmlspecialchars($_POST['user']) . ":" . crypt($_POST['pass'], "pw");
?>
Agregado.
<?php
}
?>
<form method="POST" action="<?= $_SERVER['PHP_SELF'] ?>">
<label for="user">Usuario</label>
<input type="text" name="user" size="25" maxlength="30" /><br />
<label for="pass">Contraseña</label>
<input type="password" name="pass" size="25" maxlength="30" /><br />
<input type="submit" name="enviar" value="Crear usuario" />
</form>
</article>
</section>
</body>
</html>