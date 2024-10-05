import { createRouter, createWebHistory } from "vue-router"
import HomeView from "@/pages/HomeView.vue"
import RegisterView from "@/pages/RegisterView.vue"

const routes = [
  {
    name: "home",
    path: "/",
    component: HomeView,
  },
  {
    name: "register",
    path: "/register",
    component: RegisterView,
  },
]

const router = createRouter({
  history: createWebHistory(), // Use createWebHistory for standard browser apps
  routes,
})

export default router
