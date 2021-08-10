package graphics.scenery

import graphics.scenery.backends.Renderer
import org.joml.Vector3f

/**
 * A very minimal scenery example application
 *
 * @author Ulrik Guenther <hello@ulrik.is>
 */
class MinimalSceneryExample : SceneryBase("Minimal Scenery Example") {
    override fun init() {
        renderer = hub.add(SceneryElement.Renderer,
            Renderer.createRenderer(hub, applicationName, scene, 512, 512))

        val box = Box(Vector3f(1.0f, 1.0f, 1.0f))
        box.material().diffuse = Vector3f(1.0f)
        scene.addChild(box)

        val light = PointLight(radius = 15.0f)
        light.spatial().position = Vector3f(0.0f, 0.0f, 2.0f)
        light.intensity = 5.0f
        light.emissionColor = Vector3f(1.0f, 1.0f, 1.0f)
        scene.addChild(light)

        val cam = DetachedHeadCamera()
        cam.spatial().position = Vector3f(0.0f, 0.0f, 5.0f)
        cam.perspectiveCamera(50.0f, 512, 512)
        scene.addChild(cam)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            MinimalSceneryExample().main()
        }
    }
}