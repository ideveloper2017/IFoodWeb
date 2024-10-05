<template>
  <div
    class="main-wrapper media-max-w-xs:flex-col flex flex-wrap justify-center w-full"
  >
    <!-- Page Wrapper -->
    <div class="page-wrapper">
      <div class="py-5 media-max-w-xs:px-3">
        <!-- Account Logo -->
        <div class="text-center mb-[30px]">
          <!-- <a href="admin-dashboard.html"
              ><img
                src="images/logo2.png"
                alt="Dreamguy's Technologies"
                class="w-[100px] mx-auto"
            /></a> -->
        </div>
        <!-- /Account Logo -->
        <div
          class="bg-white dark:bg-swapBg dark:text-swapText shadow-header border border-cardBorder dark:border-swapBorderPrimary rounded w-full sm:w-[480px] mx-auto overflow-hidden"
        >
          <div class="p-[30px]">
            <h3 class="text-[26px] mb-[5px] text-center">Register</h3>
            <p
              class="text-[#4c4c4c] dark:text-swapText text-lg mb-[30px] text-center"
            >
              Access to our dashboard
            </p>
            <!-- Account Form -->
            <form action="index.html">
              <div class="mb-[25px]">
                <label class="text-base mb-[5px]">Email Address</label>
                <input
                  class="block w-full inputStyle !bg-[#fbfbfb] dark:!bg-swapInput dark:text-swapText dark:border-swapBorderPrimary"
                  type="text"
                />
              </div>
              <div class="mb-[25px]">
                <label class="text-base mb-[5px]">Password</label>
                <input
                  class="block w-full inputStyle !bg-[#fbfbfb] dark:!bg-swapInput dark:text-swapText dark:border-swapBorderPrimary"
                  type="password"
                />
              </div>
              <div class="mb-[25px]">
                <label class="text-base mb-[5px]">Repeat Password</label>
                <input
                  class="block w-full inputStyle !bg-[#fbfbfb] dark:!bg-swapInput dark:text-swapText dark:border-swapBorderPrimary"
                  type="password"
                />
              </div>
              <div class="mb-[25px] text-center">
                <button
                  class="bg-gradient-to-r from-[#ff9b44] to-[#fc6075] text-white rounded block text-[22px] px-[26px] py-[10px] w-full hover:opacity-80"
                  type="submit"
                >
                  Register
                </button>
              </div>
              <div class="text-center">
                <p>
                  Already have an account?
                  <a href="index.html" class="text-primary">Login</a>
                </p>
              </div>
            </form>
            <!-- /Account Form -->
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup></script>

<style>
@import "../assets/css/custom-form.css";
</style>
