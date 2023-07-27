package com.nekofar.milad.intellij.hexo.cli

import com.intellij.execution.filters.Filter
import com.intellij.lang.javascript.boilerplate.NpmPackageProjectGenerator
import com.intellij.lang.javascript.boilerplate.NpxPackageDescriptor
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.vfs.VirtualFile
import com.nekofar.milad.intellij.hexo.HexoBundle.message
import com.nekofar.milad.intellij.hexo.HexoIcons

class HexoCliProjectGenerator : NpmPackageProjectGenerator() {
    private data class PackageInfo(val name: String, val executable: String, val command: String)

    private val packageInfo = PackageInfo("hexo", "hexo", "init")

    override fun getName() = message("hexo.project.generator.name")

    override fun getDescription() = message("hexo.project.generator.description")

    override fun filters(project: Project, baseDir: VirtualFile) = emptyArray<Filter>()

    override fun customizeModule(virtualFile: VirtualFile, contentEntry: ContentEntry?) {}

    override fun packageName() = packageInfo.name

    override fun presentablePackageName() = message("hexo.project.generator.presentable.package.name")

    override fun getNpxCommands() = listOf(NpxPackageDescriptor.NpxCommand(packageInfo.name, packageInfo.executable))

    override fun generateInTemp() = true

    override fun generatorArgs(project: Project, baseDir: VirtualFile) = arrayOf(packageInfo.command, project.name)

    override fun getIcon() = HexoIcons.ProjectGenerator
}
