/*
 * Copyright 2019 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.globits.mita.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModel
import dagger.MapKey
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass

/**
 * FragmentFactory which uses Dagger to create the instances.
 */
class XCareFragmentFactory @Inject constructor(
        private val creators: @JvmSuppressWildcards Map<Class<out Fragment>, Provider<Fragment>>
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        val fragmentClass = loadFragmentClass(classLoader, className)
        val creator: Provider<out Fragment>? = creators[fragmentClass]
        return if (creator == null) {
            Timber.v("Unknown model class: $className, fallback to default instance")
            super.instantiate(classLoader, className)
        } else {
            creator.get()
        }
    }
}

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)

