package com.nekofar.milad.intellij.hexo.cli

import com.intellij.execution.filters.Filter
import com.intellij.lang.javascript.boilerplate.NpmPackageProjectGenerator
import com.intellij.lang.javascript.boilerplate.NpxPackageDescriptor
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.vfs.VirtualFile
import com.nekofar.milad.intellij.hexo.HexoBundle
import com.nekofar.milad.intellij.hexo.HexoIcons
import javax.swing.Icon

class HexoCliProjectGenerator : NpmPackageProjectGenerator() {
    private data class PackageInfo(val name: String, val executable: String, val command: String)

    private val packageInfo = PackageInfo("hexo", "hexo", "init")

    override fun getName() = HexoBundle.message("hexo.project.generator.name")

    override fun getDescription() = HexoBundle.message("hexo.project.generator.description")

    override fun filters(project: Project, baseDir: VirtualFile) = emptyArray<Filter>()

    override fun customizeModule(p0: VirtualFile, p1: ContentEntry?) {}

    override fun packageName() = packageInfo.name

    override fun presentablePackageName() = HexoBundle.message("hexo.project.generator.presentable.package.name")

    override fun getNpxCommands(): List<NpxPackageDescriptor.NpxCommand> =
        listOf(NpxPackageDescriptor.NpxCommand(packageInfo.name, packageInfo.executable))

    override fun generateInTemp() = true

    override fun generatorArgs(project: Project?, dir: VirtualFile?, settings: Settings?) =
        arrayOf(packageInfo.command, project?.name.toString())

    override fun getIcon(): Icon = HexoIcons.ProjectGenerator
}
