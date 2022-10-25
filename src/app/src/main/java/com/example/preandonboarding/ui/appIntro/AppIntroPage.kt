@file:OptIn(ExperimentalPagerApi::class, ExperimentalPagerApi::class)

package com.example.preandonboarding.ui.appIntro

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.preandonboarding.R
import com.example.preandonboarding.components.text.BodyLargeText
import com.example.preandonboarding.components.button.LargeButton
import com.example.preandonboarding.components.text.DisplayMedium
import com.example.preandonboarding.components.image.NetworkImage
import com.example.preandonboarding.components.indicator.CustomCircleProgressIndicator
import com.example.preandonboarding.components.loading.LoadingScreen
import com.example.preandonboarding.utils.navigation.Screen
import com.example.preandonboarding.data.api.service.ApiClientService
import com.example.preandonboarding.data.api.service.appIntroPage.AppIntroRepoImpl
import com.example.preandonboarding.data.api.service.module.ModuleRepoImpl
import com.example.preandonboarding.data.model.appIntro.AppIntroConfig
import com.google.accompanist.pager.*

@Composable
fun AppIntroPage(
    appIntroViewModel: AppIntroViewModel =
        viewModel(
            factory = AppIntroVmFactory(
                ModuleRepoImpl(
                    ApiClientService.getModuleService()
                ),
                AppIntroRepoImpl(ApiClientService.getAppIntroConfigsService()),
                context = LocalContext.current
            )
        ),
    navController: NavHostController,
) {
    val pagerState = appIntroViewModel.pager

    if (appIntroViewModel.navigateToDashBoard) {
        LaunchedEffect(Unit) {
            navController.navigate(route = Screen.Dashboard.route) {
                popUpTo(route = Screen.AppIntro.route) {
                    inclusive = true
                }
            }
        }
    } else if (appIntroViewModel.navigateToLogin) {
        LaunchedEffect(Unit) {
            navController.navigate(route = Screen.Login.route) {
                popUpTo(route = Screen.AppIntro.route) {
                    inclusive = true
                }
            }
        }
    }

    LoadingScreen(isLoading = appIntroViewModel.isAppIntroLoading) {
        Box {
            AppIntroPager(
                onPageChange = { appIntroViewModel.onPageChange() },
                pagerState = pagerState,
                pageConfigs = appIntroViewModel.appIntroConfigs,
            )

            Box(
                modifier = Modifier
                    .padding(
                        start = dimensionResource(id = R.dimen.screen_padding),
                        end = dimensionResource(id = R.dimen.screen_padding),
                        bottom = dimensionResource(id = R.dimen.screen_padding)
                    )

            ) {
                Row(
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    SkipButton(
                        isVisible = appIntroViewModel.isSkipBtnVisible,
                        onSkipClicked = { appIntroViewModel.onSkip() }
                    )
                }

                Box(
                    contentAlignment = Alignment.BottomCenter,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        HorizontalPagerIndicator(
                            pagerState = pagerState,
                            activeColor = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.padding(16.dp)
                        )

                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            LoadingStatusIndicator(
                                isVisible = appIntroViewModel.isLoadingVisible,
                                status = appIntroViewModel.loadingStatus
                            )

                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.CenterEnd
                            ) {
                                GettingStartedButton(
                                    isEnabled = appIntroViewModel.isGetStartedBtnEnabled,
                                    onGettingStartedClick = {},
                                    pagerState = pagerState,
                                    totalPages = appIntroViewModel.appIntroConfigs.size,
                                    navController = navController,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@ExperimentalPagerApi
@Composable
fun AppIntroPager(
    onPageChange: () -> Unit,
    pagerState: PagerState,
    pageConfigs: List<AppIntroConfig>,
) {
    HorizontalPager(
        state = pagerState,
        count = pageConfigs.size
    ) { page ->
        onPageChange()
        AppIntroItem(appIntroConfig = pageConfigs[page])
    }
}

@ExperimentalPagerApi
@Composable
fun GettingStartedButton(
    isEnabled: Boolean,
    onGettingStartedClick: () -> Unit,
    pagerState: PagerState,
    totalPages: Int,
    navController: NavHostController,
) {
    AnimatedVisibility(
        visible = pagerState.currentPage == totalPages - 1,
    ) {
        LargeButton(
            isEnabled = isEnabled,
            text = stringResource(id = R.string.get_started),
            onClick = {
                onGettingStartedClick()
                navController.navigate(route = Screen.Dashboard.route) {
                    popUpTo(route = Screen.AppIntro.route) {
                        inclusive = true
                    }
                }
            })
    }
}

@Composable
private fun SkipButton(isVisible: Boolean, onSkipClicked: () -> Unit) {
    AnimatedVisibility(visible = isVisible) {
        TextButton(
            onClick = { onSkipClicked() },
        ) {
            Text(text = stringResource(id = R.string.skip))
        }
    }
}

@Composable
fun LoadingStatusIndicator(isVisible: Boolean = true, status: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AnimatedVisibility(visible = isVisible) {
            CustomCircleProgressIndicator(modifier = Modifier.padding(4.dp))
        }
        Text(text = status)
    }
}

@Composable
private fun AppIntroItem(appIntroConfig: AppIntroConfig) {
    val screenPadding = dimensionResource(id = R.dimen.screen_padding)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(android.graphics.Color.parseColor(appIntroConfig.color)))
            .padding(
                top = screenPadding,
                bottom = 150.dp,
                start = screenPadding,
                end = screenPadding
            )
    ) {
        DisplayMedium(appIntroConfig.title)

        Spacer(modifier = Modifier.height(32.dp))

        NetworkImage(
            url = appIntroConfig.image.url,
            contentDescription = appIntroConfig.image.contentDescription,
            modifier = Modifier.width(250.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            BodyLargeText(text = appIntroConfig.description)
        }
    }
}