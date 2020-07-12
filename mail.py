import smtplib 
# creates SMTP session 
s = smtplib.SMTP('smtp.gmail.com', 587) 
# start TLS for security 
s.starttls()   
# Authentication 
s.login("sender mail", "password") 
# message to be sent 
message = "Hey Developer,Our website is up."
# sending the mail 
s.sendmail("receiver_mail", "sender_mail", message) 
# terminating the session 
s.quit()
