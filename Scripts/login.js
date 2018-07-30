import GoogleAuth from 'vue-google-auth';
import Vue from 'vue';


Vue.use(GoogleAuth, { clientID: '415663373552-3foebghlgeuglmmaan8p0j0id0oi6vlq.apps.googleusercontent.com' });
Vue.googleAuth().load();


Vue.googleAuth().onSignIn(function (googleUser) {
    var profile = googleUser.getBasicProfile();
    console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
    console.log('Name: ' + profile.getName());
    console.log('Image URL: ' + profile.getImageUrl());
    console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
});

Vue.googleAuth().signOut(function () {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
        console.log('User signed out.');
    });
});