# App Name: University Selector

# App Logo:

![Logo](https://user-images.githubusercontent.com/46695115/68987338-87ca1480-07ee-11ea-9f3d-ddbe418f8b78.png)

# Authors:

1) Chatur Kurma
2) Samrat Adloori
3) Rajesh Tarigopula
4) Karthik Reddy Muthyala

# Contributors :

1) Chatur Kurma - Works with funtionality
2) Samrat Adloori - Works with database connectivity and backend 
3) Rajesh Tarigopula - Works with User Interface functionality
4) Karthik Reddy Muthyala - works with User Interface FrontEnd

# Supported Version:

- This application is supported with minimum sdk version: API 21: Android 5.0(Lollipop) or above
- Gradle version : 4.10.1
- Android plugin version: 3.3.1


# Installation Steps:

Installation of this app is much more easier with just few steps
1. The User can download the apk file of the Quiz App.
2. By clicking on the apk file, It install's the app in your android mobile.
3. Once the App gets installed the user can click on the App icon to open it.
4. Later on, the user can register into the app and check the university they want according to preference.


# Credentials:

1. First time user must register into the app for free.
2. The user must login into the app every time they use.
3. The user can login with the registered gmail and a valid password.
4. Admin must login to app to add or delete the university.

# Project Description :
## Activities:


The project college selector system is an application where students can search and enroll for different colleges which they want. Student can search for colleges through mobiles at anytime and anyplace. This is created for the students looking for admissions in best colleges. Even colleges get more enrollments into the institute. The system provides a list of colleges to the student where they can select their required college. After selecting the preferences, the list of universities is shown which come under their preferences. Results are display instantly and system sends the results to the respective colleges which student choose for evaluation along with student details. Here Initial procedure for conducting an admission can be automated through system.


## Features and Models:

1.	Survey : After the collecting the information, a basic survey form is displayed with a set of questions to answer in a simple way.
2.	Admin Login : The Whole system will be under the control of admin and admin provides the inputs to system. Updating / Deleting the colleges list will be done by admin.
3.	Student Login : Any student can login by creating an account. Student should provide all required information needed by college while filling the form.
4.	Student Preferences : After Login in, we have a preference page, where we enter our preferred location, Food style, culture and based on these preferences universities are shown.
5.	College selection : After creating a login, each student can see a list of colleges along their details. Colleges as per their preferences are shown.
6.	Student feedback form : Student can also give their reviews about this system by filling up a feedback form in system.


## Functionality: 
We use the database to store the values entered by students.

## Persists on the app:   
Username, password, Student Preference

## Database Used: back4App
  We are using the back4App for storing the list of all universities and their location and type of university.
- Admin Login is also saved in the database for editing the list of all universities.
- We have List of Universities, their location, type of University.
- In the Sign-up page, a new user must be created by filling the signup form .
- Sign-up page has First name, Last name, Email, Contact, password.
- We will have to save all these data in database from signup page for logging in of user and then validating it.
- After a user successfully signs up, that particular user details have to be entered in users table of cloud database.
- After user logs in, they need to take a survey, and based on the preferences in the survey the list of Universities is displayed accordingly.
- After selecting the University, we need to apply for the university through Apply button which directs to the university website.
- The user needs to take the feedback for the site development of Universities.
- Feedback of the user is also stored in the database.
- When user done entering all above-mentioned information, then on clicking submit button, it must be entered into database into table University select.

## Activity Flow Diagram:

![Hosted image](https://github.com/karthikmuthyala/ANDROID_project/blob/master/hdfc.jpg)

## Layouts of our project:
- Welcome Page:
This is an Welcome page of the webiste which shows the options to select Admin Login and Student Login. The user should select one of the option to redirect for the next page.

![1](https://github.com/karthikmuthyala/ANDROID_project/blob/master/screenshots/home.PNG)

- Student Login Page:
This is the Student Login Page which the student need to enter user id and password to login. There is the forgot password option which leads the user to set new password and there is the sign-up option for the new users.

![2](https://github.com/karthikmuthyala/ANDROID_project/blob/master/screenshots/student%20loginpage.PNG)

- Sign-up Page:
This is the sign-up page where the user need to enter the details like First Name, Last Name, Email, Contact, Password and Confirm Password to register to the website.

![3](https://github.com/karthikmuthyala/ANDROID_project/blob/master/screenshots/signup.PNG)

- Forgot Password Page:
This is the Forgot Password Page where user can set new password with his/her user name, set password and confirm password.

![4](https://github.com/karthikmuthyala/ANDROID_project/blob/master/screenshots/forgot%20password.PNG)

- Survey Page:
In this page user can see some questions like Preferred location, State or Private Universities and Climate.

![9](https://github.com/karthikmuthyala/ANDROID_project/blob/master/screenshots/survey.PNG)

- List Of Universities Page:
In this page User can see the list of universities as per the survey he gives.

![5](https://github.com/karthikmuthyala/ANDROID_project/blob/master/screenshots/universitylist.PNG)

- Selected University Page :
In this page user can see the details of the selected university like Univeristy type, Location, Graduation Rate, Required GRE Score and IELTS score with APPLY button. And these requirements changes from univeristy to university.

![6](https://github.com/karthikmuthyala/ANDROID_project/blob/master/screenshots/university%20select.PNG)

- Redirected Page :
When we click on Apply button in the selected univeristy it redirects to the univeristy website where user can apply to that particular university.

![7](https://github.com/karthikmuthyala/ANDROID_project/blob/master/screenshots/apply.PNG)

- Website Page :
When we click on Go TO COLLEGE WEBSITE button in the selected univeristy it redirects to the univeristy website where user can know about that particular university.

![12](https://github.com/karthikmuthyala/ANDROID_project/blob/master/screenshots/collegesite.PNG)

- Maps Location Page :
When we click on View in maps button in the selected univeristy it redirects to the univeristy google maps where user can see the location of that particular university.

![13](https://github.com/karthikmuthyala/ANDROID_project/blob/master/screenshots/maps.PNG)

- Feedback Page:
There is Feedback page for the users with Feedback and comments sections.

![8](https://github.com/karthikmuthyala/ANDROID_project/blob/master/screenshots/feedback.PNG)

- Admin Page:
This is the Admin Login Page which the admin need to enter user id and password to login. There is the forgot password option which leads the admin to set new password.

![10](https://github.com/karthikmuthyala/ANDROID_project/blob/master/screenshots/Admin%20login.PNG)

User-Id is km@gmail.com
and password is abcd

- Admin university list Page:
After admin login into the app he will get the view list of all the available university and he can add or delete the university.

![14](https://github.com/karthikmuthyala/ANDROID_project/blob/master/screenshots/list.PNG)

- Admin add university Page:
After clicking the add button the admin will be directed to the add university page where he should fill the university name, climate, graduation rate, type and link.

![15](https://github.com/karthikmuthyala/ANDROID_project/blob/master/screenshots/adduniversity.PNG)





