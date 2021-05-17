const API_URL = 'http://localhost:5001/api/auth/';
import post from "./request"
import { user } from "../stores/user";

export default {
  login: {
    title: "Login",
    banner: "/images/dog13.jpg",
    alt: "Sign Up",
    request: async (newUser) => {
        const response  = await post(
          API_URL + "signin",
          {
            username: newUser.username,
            password: newUser.password
          }
        )
        const userData = await response.json()
        if(userData.token){
          localStorage.setItem('user', JSON.stringify({...userData, isLoggedIn: true}));
          user.add({...userData, isLoggedIn: true})
          return true
        }
        return false
    }
  },
  signup: {
    title: "Sign Up",
    banner: "/images/dog2.jpg",
    alt: "Login",
    request: async (newUser) => {
      const response = await post(
        API_URL + "signup",
        {
          username: newUser.username,
          password: newUser.password,
          email: newUser.email,
          roles: newUser.roles || ["user"]
        }
      )
      return response.ok
    }
  },
  logout: () => {
    localStorage.removeItem('user');
    user.reset()
  }
};
