	           	'use strict';
	            let formE = document.getElementById('form_login');
	            let errorE = document.getElementById('error_login');
	
	            formE.onsubmit = function(){
	                if(formE.loginID.value === '' || formE.loginPassword.value === ''){//オブジェクトのネームの値
	                    errorE.textContent ='IDまたはパスワードが入力されていません。';
	                    return false;
	                }
	                errorE.textContent = null;//戻す
	            };
	            formE.onreset = function(){
	                errorE.textContent = null;
	            };